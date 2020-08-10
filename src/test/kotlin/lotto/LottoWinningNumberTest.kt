package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoWinningNumber
import lotto.domain.Rank
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoWinningNumberTest {

    @Test
    fun `내가 구매한 로또와 당첨번호의 비교`() {
        val lotto = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 7, 8)
        val lottoWinningNumber = LottoWinningNumber(winningNumbers)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(listOf(lotto))

        // 당첨결과 4등 -> 하나이므로 1
        Assertions.assertThat(results.size).isEqualTo(1)
    }

    @Test
    fun `1등`() {
        val lotto = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoWinningNumber = LottoWinningNumber(winningNumbers)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(listOf(lotto))

        Assertions.assertThat(results).isEqualTo(listOf(Rank.FIRST))
    }

    @Test
    fun `2등`() {
        val lotto = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 8)
        val lottoWinningNumber = LottoWinningNumber(winningNumbers)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(listOf(lotto))

        Assertions.assertThat(results).isEqualTo(listOf(Rank.SECOND))
    }

    @Test
    fun `3등`() {

        val lotto = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningNumbers = listOf(1, 2, 3, 4, 7, 8)
        val lottoWinningNumber = LottoWinningNumber(winningNumbers)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(listOf(lotto))

        Assertions.assertThat(results).isEqualTo(listOf(Rank.THIRD))
    }

    @Test
    fun `4등`() {
        val lotto = LottoTicket(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val winningNumbers = listOf(1, 2, 3, 8, 9, 12)
        val lottoWinningNumber = LottoWinningNumber(winningNumbers)

        // 로또 결과 및 분석
        val results = lottoWinningNumber.getLottoResultsOf(listOf(lotto))

        Assertions.assertThat(results).isEqualTo(listOf(Rank.FOURTH))
    }
}
