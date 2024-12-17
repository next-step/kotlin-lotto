package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `valueOf 랭크 5 테스트`() {
        val rank = Rank.valueOf(Rank.FIFTH.countOfMatch, true)
        rank shouldBe Rank.FIFTH
    }

    @Test
    fun `valueOf 랭크 2 테스트`() {
        val rank = Rank.valueOf(Rank.THIRD.countOfMatch, true)
        rank shouldBe Rank.SECOND
    }
}
