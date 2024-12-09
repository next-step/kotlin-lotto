package lotto.domain.model

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `Rank matchCount = 5, isMatchBonus = true 이면 Rank SECOND 를 반환한다`() {
        val rank =
            Rank.fromMatchCount(
                matchCount = 5,
                isMatchBonus = true,
            )

        assertTrue(rank == Rank.SECOND)
    }

    @Test
    fun `Rank matchCount = 5, isMatchBonus = false 이면 Rank THIRD 를 반환한다`() {
        val rank =
            Rank.fromMatchCount(
                matchCount = 5,
                isMatchBonus = false,
            )
        assertTrue(rank == Rank.THIRD)
    }
}
