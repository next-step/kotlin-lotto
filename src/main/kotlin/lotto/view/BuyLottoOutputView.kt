package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.WinningStatDto
import lotto.util.OutPutModule
import kotlin.math.floor

class BuyLottoOutputView(private val outPutModule: OutPutModule) {

    fun showAllBoughtTickets(boughtTickets: List<LottoTicket>, passiveBoughtTicket: List<LottoTicket>) {
        var result = ""
        result += "수동으로 ${passiveBoughtTicket.size}장, 자동으로 ${boughtTickets.size}장을 구매했습니다." + DIVIDING
        result += getTicketsNumberFormat(passiveBoughtTicket)
        result += getTicketsNumberFormat(boughtTickets)
        outPutModule.write(result)
    }

    fun showTotalWinningInformation(boughtTicketTotalMoney: Money, winningStatDTOs: List<WinningStatDto>) {
        this.showWinningStartLabel()
        this.showAllWinningStat(winningStatDTOs)
        this.showEarningsRate(boughtTicketTotalMoney, winningStatDTOs)
    }

    private fun getTicketsNumberFormat(lottoTickets: List<LottoTicket>): String = with(StringBuilder()) {
        lottoTickets.forEach { lottoTicket ->
            lottoTicket.lottoTicketNumbers.value
                .map { it.value }
                .sorted()
                .joinToString(prefix = "[", postfix = "]")
                .let(this::appendLine)
        }
        return this.toString()
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
        var bonusBallFormat = ""
        if (winningStatDto.lottoRank.includeBonusNumber()) {
            bonusBallFormat = ", 보너스 볼 일치"
        }
        return "${winningStatDto.lottoRank.winningNumberMatchCount}개 일치$bonusBallFormat (${winningStatDto.lottoRank.wonPrize.value}원)- ${winningStatDto.totalWinningCount}개"
    }

    private fun showEarningsRate(boughtTicketTotalMoney: Money, winningStatDTOs: List<WinningStatDto>) {
        var totalPrizeInt: Long = 0
        winningStatDTOs.forEach { winningStatDto -> totalPrizeInt += winningStatDto.totalWinningPrize.value }
        val earningsRate = floor((totalPrizeInt.toDouble() / boughtTicketTotalMoney.value) * 100) / 100
        outPutModule.write("총 수익률은 ${earningsRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    companion object {
        private const val DIVIDING = "\n"
    }
}
