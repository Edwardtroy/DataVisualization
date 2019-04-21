package DataVisualization.infrastructure

import DataVisualization.service.ArcDiagram.ArcDiagramService

fun main() {
    val content = CSVFileReader()
            .load("dependencies.csv")

    val diagram = ArcDiagramService()
            .toArcDiagram(content)

    FileRepository(ArcDiagramService())
            .store(diagram, "output/ArcDiagram.json")
}
