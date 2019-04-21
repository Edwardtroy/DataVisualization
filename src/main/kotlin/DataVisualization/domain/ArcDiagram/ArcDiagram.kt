package DataVisualization.domain.ArcDiagram

import kotlinx.serialization.Serializable

@Serializable
data class ArcDiagram(val nodes: Array<Node>, val links: Array<Link>)

@Serializable
data class Node(val id: String, val group: String)

@Serializable
data class Link(val source: String, val target: String, val value: Int)
