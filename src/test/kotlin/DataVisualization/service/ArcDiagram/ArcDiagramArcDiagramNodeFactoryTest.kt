package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcDiagramNode
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class ArcDiagramArcDiagramNodeFactoryTest {
    @Test
    fun `should create two node when given content`() {
        val content = listOf(
                "owner,1,node,owner,2,node,,HARD",
                "owner,2,node,owner,1,node,,HARD"
        )

        val nodes = ArcDiagramNodeFactory().createNodesFrom(content)

        assertThat(nodes.size).isEqualTo(2)
        assertThat(nodes.first()).isEqualTo(ArcDiagramNode("1, node", "owner"))
        assertThat(nodes.last()).isEqualTo(ArcDiagramNode("2, node", "owner"))
    }
}
