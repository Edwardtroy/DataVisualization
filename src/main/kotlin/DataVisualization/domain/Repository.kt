package DataVisualization.domain

interface Repository {
    fun store(diagram: Diagram, fileName: String)
}