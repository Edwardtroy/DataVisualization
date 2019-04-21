package DataVisualization.domain.ArcDiagram

import DataVisualization.domain.Diagram
import kotlinx.serialization.Serializable

const val DEFAULT_VALUE_NUMBER_FOR_ARC_DIAGRAM = 1

@Serializable
data class ArcDiagram(val nodes: List<ArcDiagramNode>, val links: List<ArcLink>): Diagram()

@Serializable
data class ArcDiagramNode(val id: String, val group: String)

@Serializable
data class ArcLink(val source: String, val target: String, val value: Int)
