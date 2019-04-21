package DataVisualization.infrastructure

import DataVisualization.service.ArcDiagram.ArcDiagramService

fun main() {
    val reader = CSVFileReader()
    val content = reader.load("dependencies.csv")
    val diagram = ArcDiagramService().toArcDiagram(content)
    val repository = CSVFileRepository(ArcDiagramService())
    repository.store(diagram, "output/ArcDiagram.json")
}
