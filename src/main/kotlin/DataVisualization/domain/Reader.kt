package DataVisualization.domain

interface Reader {
    fun load(fileName: String): List<String>
}