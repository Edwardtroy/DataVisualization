package DataVisualization.service.HivePlot

import DataVisualization.domain.HivePlot.HivePlotNode
import DataVisualization.service.sizeShouldBe

class HivePlotNodeFactory {
    fun createNodesFrom(content: List<String>): List<HivePlotNode> {
        val nodeNameList = getNodeNameList(content)

        val importsMap = getImportsMap(content, nodeNameList)

        return nodeNameList.map {
            HivePlotNode(name = it, size = 1, imports = importsMap.get(it)!!)
        }
    }

    private fun getNodeNameList(content: List<String>): List<String> {
        val nodeNameList = ArrayList<String>()

        content.map {
            it.split(",").sizeShouldBe(8)
        }.forEach {
            nodeNameList.add("${it[0]}.${it[1]}.${it[2]}")
            nodeNameList.add("${it[3]}.${it[4]}.${it[5]}")
        }

        return nodeNameList.distinct()
    }

    private fun getImportsMap(content: List<String>, nodeNameList: List<String>): HashMap<String, ArrayList<String>> {
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
            importsMap.put(nodeName, importsList)
        }

        return importsMap
    }
}
