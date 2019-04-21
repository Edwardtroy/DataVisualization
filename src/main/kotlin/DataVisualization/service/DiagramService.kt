package DataVisualization.service

import DataVisualization.domain.Diagram

interface DiagramService {
    fun transferToString(diagram: Diagram): String
}