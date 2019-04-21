package DataVisualization.service.SankeyDiagram

import DataVisualization.domain.Sankey.SankeyDiagramNode
import DataVisualization.service.sizeShouldBe

class SankeyDiagramNodeFactory {
    fun createNodesFrom(content: List<String>): List<SankeyDiagramNode> {
        val nodeList = ArrayList<SankeyDiagramNode>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            nodeList.add(SankeyDiagramNode(name = "${it[1]}, ${it[2]}"))
            nodeList.add(SankeyDiagramNode(name = "${it[4]}, ${it[5]}"))
        }

        return nodeList.distinct()
    }
}
