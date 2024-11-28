package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class MatchResultTest {
    @Test
    fun `총상금을 계산한다`() {
        val result =
            MatchResult.of(
                Rank.FOURTH to 1,
                Rank.FIFTH to 1,
                Rank.MISS to 12,
            )

        result.totalPrize shouldBe 55_000
    }
}
