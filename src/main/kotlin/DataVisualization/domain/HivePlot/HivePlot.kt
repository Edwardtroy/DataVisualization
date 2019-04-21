package DataVisualization.domain.HivePlot

import DataVisualization.domain.Diagram
import kotlinx.serialization.Serializable

const val DEFAULT_VALUE_NUMBER_FOR_HIVE_PLOT = 1

@Serializable
data class HivePlot(val nodes: List<HivePlotNode>): Diagram()

@Serializable
data class HivePlotNode(val name: String, val size: Int = DEFAULT_VALUE_NUMBER_FOR_HIVE_PLOT, val imports: List<String>)
