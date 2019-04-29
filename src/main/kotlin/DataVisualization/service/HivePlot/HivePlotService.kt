package DataVisualization.service.HivePlot

import DataVisualization.domain.Diagram
import DataVisualization.domain.HivePlot.HivePlot
import DataVisualization.service.DiagramService
import kotlinx.serialization.json.Json

class HivePlotService: DiagramService{
    override fun transferToString(diagram: Diagram): String {
        return Json.stringify(HivePlot.serializer(), diagram as HivePlot)
    }

    fun toHivePlot(content: List<String>): HivePlot {
        val nodes = HivePlotNodeFactory(content).createNodesFrom()

        return HivePlot(nodes)
    }
}