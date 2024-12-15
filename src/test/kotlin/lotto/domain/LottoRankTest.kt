package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `로또 티켓의 번호가 6개 모두 일치하면 1등이다`() {
        val rank = LottoRank.getRank(6, true)
        rank shouldBe LottoRank.FIRST_PLACE
        rank.prize shouldBe 2_000_000_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 5개 일치하고 보너스번호도 일치하면 2등이다`() {
        val rank = LottoRank.getRank(5, true)
        rank shouldBe LottoRank.SECOND_PLACE
        rank.prize shouldBe 30_000_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 4개 일치하고 보너스번호가 일치하지 않으면 3등이다`() {
        val rank = LottoRank.getRank(5, false)
        rank shouldBe LottoRank.THIRD_PLACE
        rank.prize shouldBe 1_500_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 4개 일치하면 4등이다`() {
        val rank = LottoRank.getRank(4, true)
        rank shouldBe LottoRank.FOURTH_PLACE
        rank.prize shouldBe 50_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 3개 일치하면 5등이다`() {
        val rank = LottoRank.getRank(3, true)
        rank shouldBe LottoRank.FIFTH_PLACE
        rank.prize shouldBe 5_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 2개 일치하면 꽝이다`() {
        val rank = LottoRank.getRank(2, true)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 1개 일치하면 꽝이다`() {
        val rank = LottoRank.getRank(1, true)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호가 당첨 티켓 번호와 하나도 일치하지 않으면 꽝이다`() {
        val rank = LottoRank.getRank(0, true)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }
}
