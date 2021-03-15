package lotto.domain

import lotto.data.LottoNumbers
import lotto.data.WinningNumbers
import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LotteryTicketTest {

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(3개 일치한 경우)`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9), 45)

        assertThat(lotteryTicket.findWinningType(winningNumbers)).isEqualTo(LotteryMatchType.Three)
    }

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(2개 일치한 경우)`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(5, 6, 7, 8, 9, 10), 45)

        assertThat(lotteryTicket.findWinningType(winningNumbers)).isEqualTo(LotteryMatchType.NonProfit)
    }

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(0개 일치한 경우)`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(7, 8, 9, 10, 11, 12), 45)

        assertThat(lotteryTicket.findWinningType(winningNumbers)).isEqualTo(LotteryMatchType.NonProfit)
    }

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(5개와 보너스번호가 일치한 경우)`() {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(2, 3, 4, 5, 6, 7), 1)

        assertThat(lotteryTicket.findWinningType(winningNumbers)).isEqualTo(LotteryMatchType.FiveWithBonus)
    }
}
