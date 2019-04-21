package DataVisualization.infrastructure

import DataVisualization.domain.Diagram
import DataVisualization.domain.Repository
import DataVisualization.service.DiagramService
import java.io.FileWriter
import java.io.IOException

class CSVFileRepository(private val diagramService: DiagramService): Repository {
    override fun store(diagram: Diagram, fileName: String) {
        lateinit var fileWriter: FileWriter

        try {
            fileWriter = FileWriter(fileName, false)
            fileWriter.append(diagramService.transferToString(diagram))

            println("Write JSON File successfully!")
        } catch (e: Exception) {
            println("Writing JSON File error! Exception: $e")
        } finally {
            try {
                fileWriter.flush()
                fileWriter.close()
            } catch (e: IOException) {
                println("Flushing/closing error!")
            }
        }
    }
}