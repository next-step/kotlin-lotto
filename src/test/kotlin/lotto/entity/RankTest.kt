package lotto.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RankTest {
    @Test
    fun `6개를 맞추면 1등이다`() {
        // when
        val firstPlace = Rank.find(6)

        // then
        Assertions.assertThat(firstPlace).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `4개를 맞추면 3등이다`() {
        // when
        val firstPlace = Rank.find(4)

        // then
        Assertions.assertThat(firstPlace).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `2개를 맞추면 당첨되지 않는다`() {
        // when
        val firstPlace = Rank.find(1)

        // then
        Assertions.assertThat(firstPlace).isEqualTo(Rank.MISS)
    }

    @Test
    fun `1개를 맞추면 당첨되지 않는다`() {
        // when
        val firstPlace = Rank.find(1)

        // then
        Assertions.assertThat(firstPlace).isEqualTo(Rank.MISS)
    }
}
