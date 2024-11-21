package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `일치갯수로 Rank를 알 수 있다`() {
        val rank = Rank.match(3)

        assertThat(rank).isEqualTo(Rank.FOURTH)
    }
}
