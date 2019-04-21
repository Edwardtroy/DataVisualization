package DataVisualization.domain.Sankey

import DataVisualization.domain.Diagram
import kotlinx.serialization.*

const val DEFAULT_VALUE_NUMBER_FOR_SANKEY_DIAGRAM = 1

@Serializable
data class SankeyDiagram(val nodes: List<SankeyDiagramNode>, val links: List<SankeyLink>): Diagram()

@Serializable
data class SankeyDiagramNode(val name: String)

@Serializable
data class SankeyLink(val source: Int, val target: Int, val value: Int = DEFAULT_VALUE_NUMBER_FOR_SANKEY_DIAGRAM)