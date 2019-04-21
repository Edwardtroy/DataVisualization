package DataVisualization.service

import DataVisualization.domain.Diagram
import DataVisualization.service.Exceptions.WrongInputFormatException

interface DiagramService {
    fun transferToString(diagram: Diagram): String
}

fun List<String>.sizeShouldBe(size: Int): List<String> {
    return if (this.size == size) this
    else throw WrongInputFormatException("Wrong input format!")
}