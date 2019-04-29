package DataVisualization.service.HivePlot

import DataVisualization.domain.HivePlot.HivePlotNode
import DataVisualization.service.sizeShouldBe

class HivePlotNodeFactory {
    private lateinit var nodeNameList: List<String>
    private lateinit var content: List<String>

    fun createNodesFrom(content: List<String>): List<HivePlotNode> {
        this.content = content
        this.nodeNameList = getNodeNameList()

        val importsMap = getImportsMap()

        return nodeNameList.map {
            HivePlotNode(name = it, size = 1, imports = importsMap[it]!!)
        }
    }

    private fun getNodeNameList(): List<String> {
        val nodeNameList = ArrayList<String>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            nodeNameList.add("${it[0]}.${it[1]}.${it[2]}")
            nodeNameList.add("${it[3]}.${it[4]}.${it[5]}")
        }

        return nodeNameList.distinct()
    }

    private fun getImportsMap(): HashMap<String, ArrayList<String>> {
        val importsMap = HashMap<String, ArrayList<String>>()

        val input = content.map {
            it.split(",").sizeShouldBe(8)
        }

        nodeNameList.forEach {
            val nodeName = it
            val importsList = ArrayList<String>()
            input.filter { "${it[3]}.${it[4]}.${it[5]}" == nodeName }
                    .forEach {
                        importsList.add("${it[0]}.${it[1]}.${it[2]}")
                    }
            importsMap[nodeName] = importsList
        }

        return importsMap
    }
}
