package DataVisualization.service.HivePlot

import DataVisualization.domain.HivePlot.HivePlotNode
import DataVisualization.service.sizeShouldBe

class HivePlotNodeFactory(content: List<String>) {
    private var inputs: List<List<String>> = content.map {
        it.split(",").sizeShouldBe(8)
    }
    private lateinit var nodeNameList: List<String>
    private var relationMap = HashMap<String, String>()

    fun createNodesFrom(): List<HivePlotNode> {
        this.nodeNameList = getNodeNameList()

        val importsMap = getImportsMap()

        return nodeNameList.map {
            HivePlotNode(name = it, size = 1, imports = importsMap[it]!!)
        }
    }

    private fun getNodeNameList(): List<String> {
        val nodeNameList = ArrayList<String>()

        inputs.forEach {
            nodeNameList.add("${it[0]}.${it[1]}.${it[2]}")
            nodeNameList.add("${it[3]}.${it[4]}.${it[5]}")
        }

        return nodeNameList.distinct()
    }

    private fun getImportsMap(): HashMap<String, ArrayList<String>> {
        val importsMap = HashMap<String, ArrayList<String>>()

        nodeNameList.forEach {
            val nodeName = it
            val importsList = ArrayList<String>()
            inputs.filter { "${it[3]}.${it[4]}.${it[5]}" == nodeName }
                    .forEach {
                        importsList.add("${it[0]}.${it[1]}.${it[2]}")
                    }
            importsMap[nodeName] = importsList
        }

        return importsMap
    }

    fun getRootNode(): List<String> {
        val from = ArrayList<String>()
        val to = ArrayList<String>()

        inputs.forEach {
            val fromElement = "${it[0]}.${it[1]}.${it[2]}"
            val toElement = "${it[3]}.${it[4]}.${it[5]}"
            from.add(fromElement)
            to.add(toElement)
            relationMap[fromElement] = toElement
        }

        return from.distinct().filterNot {
            to.contains(it)
        }.distinct()
    }
}
