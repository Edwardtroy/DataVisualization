package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcDiagram
import DataVisualization.domain.Diagram
import DataVisualization.service.DiagramService
import DataVisualization.service.Exceptions.WrongInputFormatException
import kotlinx.serialization.json.Json

class ArcDiagramService: DiagramService {
    override fun transferToString(diagram: Diagram): String {
        return Json.stringify(ArcDiagram.serializer(), diagram as ArcDiagram)
    }

    fun toArcDiagram(content: List<String>): ArcDiagram {
        val nodes = NodeFactory().createNodesFrom(content)
        val links = LinkFactory().createLinkFrom(content)

        return ArcDiagram(nodes, links)
    }
}

fun List<String>.sizeShouldBe(size: Int): List<String> {
    return if (this.size == size) this
    else throw WrongInputFormatException("Wrong input format!")
}