package DataVisualization.service.ArcDiagram

import DataVisualization.domain.ArcDiagram.Link
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LinkFactoryTest {
    @Test
    fun `should create two links when input is just contain one connection`() {
        val content = listOf(
                "owner,1,node,owner,2,node,,HARD",
                "owner,2,node,owner,1,node,,HARD"
        )

        val links = LinkFactory().createLinkFrom(content)

        assertThat(links.size).isEqualTo(2)
        assertThat(links.first()).isEqualTo(Link("1, node", "2, node", 1))
        assertThat(links.last()).isEqualTo(Link("2, node", "1, node", 1))
    }
}
