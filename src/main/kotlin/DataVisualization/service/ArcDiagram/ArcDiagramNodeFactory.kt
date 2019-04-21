package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcDiagramNode
import DataVisualization.service.sizeShouldBe

class ArcDiagramNodeFactory {
    fun createNodesFrom(content: List<String>): List<ArcDiagramNode> {
        val nodeList = ArrayList<ArcDiagramNode>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            nodeList.add(ArcDiagramNode(id = "${it[1]}, ${it[2]}", group = it[0]))
            nodeList.add(ArcDiagramNode(id = "${it[4]}, ${it[5]}", group = it[3]))
        }

        return nodeList.distinctBy { it.id + it.group }
    }
}
