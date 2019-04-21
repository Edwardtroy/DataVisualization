package DataVisualization.infrastructure

import DataVisualization.domain.Reader
import java.io.FileNotFoundException
import java.io.IOException

class CSVFileReader: Reader {
    override fun load(fileName: String): List<String> {
        val contents: List<String>
        val classLoader = Thread.currentThread().contextClassLoader
        val inputStream = classLoader.getResourceAsStream(fileName)
                ?: throw FileNotFoundException("Input file not found with name: $fileName")

        val bufferedReader = inputStream.bufferedReader()
        contents = bufferedReader.readLines()

        try {
            bufferedReader.close()
        } catch (exception: IOException) {
            exception.printStackTrace()
        }

        return contents
    }
}