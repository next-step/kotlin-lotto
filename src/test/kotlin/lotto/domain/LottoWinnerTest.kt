package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicketTest.Companion.DEFAULT_LOTTO_TICKET
import lotto.domain.LottoTicketTest.Companion.makeLottoNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class LottoWinnerTest {
    @Test
    fun `당첨 번호(LottoWinner) 생성 확인`() {
        assertDoesNotThrow { DEFAULT_LOTTO_WINNER }
    }

    @Test
    fun `LottoWinner 의 2 랭크 확인`() {
        DEFAULT_LOTTO_WINNER.getRank(
            LottoTicket(
                makeLottoNumbers(1, 2, 3, 4, 5, 10),
            ),
        ) shouldBe Rank.SECOND
    }

    @Test
    fun `LottoWinner 의 3 랭크 확인`() {
        DEFAULT_LOTTO_WINNER.getRank(
            LottoTicket(
                makeLottoNumbers(1, 2, 3, 4, 5, 7),
            ),
        ) shouldBe Rank.THIRD
    }

    companion object {
        val DEFAULT_BONUS_NUMBER = LottoNumber(10)
        val DEFAULT_LOTTO_WINNER = LottoWinner(DEFAULT_LOTTO_TICKET, DEFAULT_BONUS_NUMBER)
    }
}
