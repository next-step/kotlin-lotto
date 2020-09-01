package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.LottoWinningNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoWinningNumberTest {

    @Test
    fun `내가 구매한 로또와 당첨번호의 비교 - 1등`() {
        val lotto = listOf<LottoTicket>(
            LottoTicket.from(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusBall = 7
        val lottoWinningNumber = LottoWinningNumber(winningNumbers, bonusBall)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(LottoTickets.from(lotto))
        Assertions.assertThat(results).isEqualTo(listOf(Rank.FIRST))
    }

    @Test
    fun `내가 구매한 로또와 당첨번호의 비교 - 2등`() {
        val lotto = listOf<LottoTicket>(
            LottoTicket.from(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 8)
        val bonusBall = 6
        val lottoWinningNumber = LottoWinningNumber(winningNumbers, bonusBall)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(LottoTickets.from(lotto))
        Assertions.assertThat(results).isEqualTo(listOf(Rank.SECOND))
    }

    @Test
    fun `내가 구매한 로또와 당첨번호의 비교 - 3등`() {
        val lotto = listOf<LottoTicket>(
            LottoTicket.from(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 8)
        val bonusBall = 7
        val lottoWinningNumber = LottoWinningNumber(winningNumbers, bonusBall)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(LottoTickets.from(lotto))
        Assertions.assertThat(results).isEqualTo(listOf(Rank.THIRD))
    }
}
