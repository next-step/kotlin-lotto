package lotto.domain

import lotto.data.WinningNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LotteryTicketTest {

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(3개 일치한 경우)`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9))

        assertThat(lotteryTicket.findMatchCount(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(2개 일치한 경우)`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(5, 6, 7, 8, 9, 10))

        assertThat(lotteryTicket.findMatchCount(winningNumbers)).isEqualTo(2)
    }

    @Test
    fun `몇 개의 숫자가 일치했는지 확인한다(0개 일치한 경우)`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteryTicket = LotteryTicket(lottoNumbers)

        val winningNumbers = WinningNumbers(listOf(7, 8, 9, 10, 11, 12))

        assertThat(lotteryTicket.findMatchCount(winningNumbers)).isEqualTo(0)
    }
}
