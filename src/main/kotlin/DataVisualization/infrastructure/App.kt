package DataVisualization.infrastructure

import DataVisualization.service.ArcDiagram.ArcDiagramService
import DataVisualization.service.HivePlot.HivePlotService
import DataVisualization.service.SankeyDiagram.SankeyDiagramService

fun main() {
    val content = CSVFileReader()
            .load("dependencies.csv")

    val arcDiagram = ArcDiagramService()
            .toArcDiagram(content)

    FileRepository(ArcDiagramService())
            .store(arcDiagram, "output/ArcDiagram.json")

    val hivePlot = HivePlotService()
            .toHivePlot(content)

    FileRepository(HivePlotService())
            .store(hivePlot, "output/HivePlot.json")

    val sankeyDiagram = SankeyDiagramService()
            .toSankeyDiagram(content)

    FileRepository(SankeyDiagramService())
            .store(sankeyDiagram, "output/SankeyDiagram.json")
}
