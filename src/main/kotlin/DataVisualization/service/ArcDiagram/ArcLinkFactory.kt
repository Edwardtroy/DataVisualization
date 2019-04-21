package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcLink
import DataVisualization.service.sizeShouldBe

class ArcLinkFactory {
    fun createLinkFrom(content: List<String>): List<ArcLink> {
        val linkList = ArrayList<ArcLink>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            linkList.add(ArcLink(source = "${it[1]}, ${it[2]}", target = "${it[4]}, ${it[5]}"))
        }

        return linkList
    }
}