package DataVisualization.domain.ArcDiagram

import DataVisualization.domain.Diagram
import kotlinx.serialization.Serializable

const val DEFAULT_VALUE_NUMBER = 1

@Serializable
data class ArcDiagram(val nodes: List<Node>, val links: List<Link>): Diagram()

@Serializable
data class Node(val id: String, val group: String)

@Serializable
data class Link(val source: String, val target: String, val value: Int)
