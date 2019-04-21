package DataVisualization.service.SankeyDiagram

import DataVisualization.domain.Sankey.SankeyDiagramNode
import DataVisualization.domain.Sankey.SankeyLink
import DataVisualization.service.sizeShouldBe

class SankeyLinkFactory(private val nodes: List<SankeyDiagramNode>) {
    fun createLinkFrom(content: List<String>): List<SankeyLink> {
        val linkList = ArrayList<SankeyLink>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            val sourceNode = SankeyDiagramNode("${it[1]}, ${it[2]}")
            val targetNode = SankeyDiagramNode("${it[4]}, ${it[5]}")
            linkList.add(SankeyLink(source = nodes.indexOf(sourceNode), target = nodes.indexOf(targetNode)))
        }

        return linkList
    }
}
