package DataVisualization.service.HivePlot

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class HivePlotNodeFactoryTest {
    @Test
    fun `should get 1 root node when input is correctly`() {
        val content = listOf(
                "owner,1,node,owner,2,node,,HARD",
                "owner,3,node,owner,1,node,,HARD"
        )

        val rootNodes = HivePlotNodeFactory(content).getRootNode()

        assertThat(rootNodes.size).isEqualTo(1)
        assertThat(rootNodes.first()).isEqualTo("owner.3.node")
    }

    @Test
    fun `should return 2 root nodes when input is correctly`() {
        val content = listOf(
                "owner,1,node,owner,2,node,,HARD",
                "owner,3,node,owner,1,node,,HARD",
                "owner,4,node,owner,1,node,,HARD"
        )

        val rootNodes = HivePlotNodeFactory(content).getRootNode()

        assertThat(rootNodes.size).isEqualTo(2)
        assertThat(rootNodes.first()).isEqualTo("owner.3.node")
        assertThat(rootNodes.last()).isEqualTo("owner.4.node")
    }
}
