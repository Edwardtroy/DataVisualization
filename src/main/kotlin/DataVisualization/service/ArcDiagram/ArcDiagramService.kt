package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcDiagram
import DataVisualization.domain.Diagram
import DataVisualization.service.DiagramService
import kotlinx.serialization.json.Json

class ArcDiagramService: DiagramService {
    override fun transferToString(diagram: Diagram): String {
        return Json.stringify(ArcDiagram.serializer(), diagram as ArcDiagram)
    }

    fun toArcDiagram(content: List<String>): ArcDiagram {
        val nodes = ArcDiagramNodeFactory().createNodesFrom(content)
        val links = ArcLinkFactory().createLinkFrom(content)

        return ArcDiagram(nodes, links)
    }
}

