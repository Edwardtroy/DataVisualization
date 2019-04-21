package DataVisualization.service.SankeyDiagram

import DataVisualization.domain.Diagram
import DataVisualization.domain.Sankey.SankeyDiagram
import DataVisualization.service.DiagramService
import kotlinx.serialization.json.Json

class SankeyDiagramService: DiagramService {
    override fun transferToString(diagram: Diagram): String {
        return Json.stringify(SankeyDiagram.serializer(), diagram as SankeyDiagram)
    }

    fun toSankeyDiagram(content: List<String>): SankeyDiagram {
        val nodes = SankeyDiagramNodeFactory().createNodesFrom(content)
        val links = SankeyLinkFactory(nodes).createLinkFrom(content)

        return SankeyDiagram(nodes, links)
    }
}