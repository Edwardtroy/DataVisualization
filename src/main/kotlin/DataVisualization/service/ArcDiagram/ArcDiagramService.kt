package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcDiagram
import DataVisualization.service.Exceptions.WrongInputFormatException

class ArcDiagramService {
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