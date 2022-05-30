package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.WinningStatDto
import lotto.util.OutPutModule
import kotlin.math.floor

class BuyLottoOutputView(private val outPutModule: OutPutModule) {

    fun showAllBoughtTickets(boughtTickets: List<LottoTicket>) {
        var result = ""
        result += "${boughtTickets.size}를 구매했습니다" + DIVIDING
        boughtTickets.forEach { lottoTicket ->
            result += lottoTicket
                .lottoTicketNumbers.value.map { it.value }.sorted()
                .joinToString(prefix = "[", postfix = "]") + DIVIDING
        }
        outPutModule.write(result)
    }

    fun showTotalWinningInformation(boughtTicketTotalMoney: Money, winningStatDTOs: List<WinningStatDto>) {
        this.showWinningStartLabel()
        this.showAllWinningStat(winningStatDTOs)
        this.showEarningsRate(boughtTicketTotalMoney, winningStatDTOs)
    }

    private fun showWinningStartLabel() {
        outPutModule.write(
            """당첨통계
---------"""
        )
    }

    private fun showAllWinningStat(winningStatDTOs: List<WinningStatDto>) {
        outPutModule.write(
            winningStatDTOs.joinToString(separator = DIVIDING) { winningStatDto ->
                getWiningStatTemplate(
                    winningStatDto
                )
            }
        )
    }

    private fun getWiningStatTemplate(winningStatDto: WinningStatDto): String {
        return "${winningStatDto.lottoPrizePolicy.winningNumberMatchCount}개 일치 (${winningStatDto.lottoPrizePolicy.wonPrize.value})-${winningStatDto.totalWinningCount}개"
    }

    private fun showEarningsRate(boughtTicketTotalMoney: Money, winningStatDTOs: List<WinningStatDto>) {
        var totalPrizeInt = 0
        winningStatDTOs.forEach { winningStatDto -> totalPrizeInt += winningStatDto.totalWinningPrize.value }
        val earningsRate = floor((totalPrizeInt.toDouble() / boughtTicketTotalMoney.value) * 100) / 100
        outPutModule.write("총 수익률은 ${earningsRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    companion object {
        private const val DIVIDING = "\n"
    }
}
