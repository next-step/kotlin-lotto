package lotto.domain

import lotto.enums.LotteryMatchType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningStatisticsTest {

    @Test
    fun `아무 통계값도 들어오지 않은 경우, getTicketCountOf는 항상 0을 리턴한다`() {
        val winningStatistics = WinningStatistics()

        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Three)).isEqualTo(0)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(0)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Five)).isEqualTo(0)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Six)).isEqualTo(0)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.NonProfit)).isEqualTo(0)
    }

    @Test
    fun `4개 맞은 티켓을 추가한 경우, getTicketCountOf는 추가한 숫자 만큼 리턴한다`() {
        val winningStatistics = WinningStatistics()
        winningStatistics.addTicketOf(LotteryMatchType.Four)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(1)

        winningStatistics.addTicketOf(LotteryMatchType.Four)
        assertThat(winningStatistics.getTicketCountOf(LotteryMatchType.Four)).isEqualTo(2)
    }

}
