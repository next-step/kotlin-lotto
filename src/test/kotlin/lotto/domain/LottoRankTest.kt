package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `로또 티켓의 번호가 6개 모두 일치하면 1등이다`() {
        val rank = LottoRank.getRank(6)
        rank shouldBe LottoRank.FIRST_PLACE
        rank.prize shouldBe 2_000_000_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 5개 일치하면 2등이다`() {
        val rank = LottoRank.getRank(5)
        rank shouldBe LottoRank.SECOND_PLACE
        rank.prize shouldBe 1_500_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 4개 일치하면 3등이다`() {
        val rank = LottoRank.getRank(4)
        rank shouldBe LottoRank.THIRD_PLACE
        rank.prize shouldBe 50_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 3개 일치하면 4등이다`() {
        val rank = LottoRank.getRank(3)
        rank shouldBe LottoRank.FOURTH_PLACE
        rank.prize shouldBe 5_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 2개 일치하면 꽝이다`() {
        val rank = LottoRank.getRank(2)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 1개 일치하면 꽝이다`() {
        val rank = LottoRank.getRank(1)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호가 당첨 티켓 번호와 하나도 일치하지 않으면 꽝이다`() {
        val rank = LottoRank.getRank(0)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }
}
