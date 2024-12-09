package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoRankTest {
    @Test
    fun `로또 티켓의 번호와 당첨 티켓이 6개 모두 일치하면 1등이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(1, 2, 3, 4, 5, 6)))
        matchRank shouldBe LottoRank.FIRST_PLACE
        matchRank.prize shouldBe 2_000_000_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 5개 일치하면 2등이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(1, 2, 3, 4, 5, 16)))
        matchRank shouldBe LottoRank.SECOND_PLACE
        matchRank.prize shouldBe 1_500_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 4개 일치하면 3등이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(1, 2, 3, 4, 15, 16)))
        matchRank shouldBe LottoRank.THIRD_PLACE
        matchRank.prize shouldBe 50_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 3개 일치하면 4등이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(1, 2, 3, 14, 15, 16)))
        matchRank shouldBe LottoRank.FOURTH_PLACE
        matchRank.prize shouldBe 5_000
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 2개 일치하면 꽝이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(1, 2, 13, 14, 15, 16)))
        matchRank shouldBe LottoRank.BLANK_PLACE
        matchRank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호와 당첨 티켓 번호가 1개 일치하면 꽝이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(1, 12, 13, 14, 15, 16)))
        matchRank shouldBe LottoRank.BLANK_PLACE
        matchRank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호가 당첨 티켓 번호와 하나도 일치하지 않으면 꽝이다`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6))
        val matchRank = winningLotto.matchedCount(LottoTicket(listOf(11, 12, 13, 14, 15, 16)))
        matchRank shouldBe LottoRank.BLANK_PLACE
        matchRank.prize shouldBe 0
    }
}
