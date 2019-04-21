package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.ArcLink
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class ArcArcLinkFactoryTest {
    @Test
    fun `should create two links when input is just contain one connection`() {
        val content = listOf(
                "owner,1,node,owner,2,node,,HARD",
                "owner,2,node,owner,1,node,,HARD"
        )

        val links = ArcLinkFactory().createLinkFrom(content)

        assertThat(links.size).isEqualTo(2)
        assertThat(links.first()).isEqualTo(ArcLink("1, node", "2, node", 1))
        assertThat(links.last()).isEqualTo(ArcLink("2, node", "1, node", 1))
    }
}
