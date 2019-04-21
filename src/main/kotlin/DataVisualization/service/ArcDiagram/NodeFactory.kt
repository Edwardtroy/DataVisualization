package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.Node

class NodeFactory {
    fun createNodesFrom(content: List<String>): List<Node> {
        val nodeList = ArrayList<Node>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            nodeList.add(Node(id = "${it[1]}, ${it[2]}", group = it[0]))
            nodeList.add(Node(id = "${it[4]}, ${it[5]}", group = it[3]))
        }

        return nodeList.distinctBy { it.id + it.group }
    }
}
