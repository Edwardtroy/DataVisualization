package DataVisualization.domain.ArcDiagram

import kotlinx.serialization.json.Json
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ArcDiagramTest {
    @Test
    fun `should be deserialize as arc diagram when given a correct json string`() {
        val jsonString = """{"nodes":[{"id":"node1","group":"group1"},{"id":"node2","group":"group2"}],"links":[{"source":"node1","target":"node2","value":100}]}"""

        val arcDiagram = Json.parse(ArcDiagram.serializer(), jsonString)

        assertThat(arcDiagram.nodes.size).isEqualTo(2)
        assertThat(arcDiagram.nodes.first().id).isEqualTo("node1")
        assertThat(arcDiagram.nodes.first().group).isEqualTo("group1")
        assertThat(arcDiagram.nodes.last().id).isEqualTo("node2")
        assertThat(arcDiagram.nodes.last().group).isEqualTo("group2")

        assertThat(arcDiagram.links.size).isEqualTo(1)
        assertThat(arcDiagram.links.first().source).isEqualTo("node1")
        assertThat(arcDiagram.links.first().target).isEqualTo("node2")
        assertThat(arcDiagram.links.first().value).isEqualTo(100)
    }
}
