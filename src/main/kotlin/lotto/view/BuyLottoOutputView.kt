package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.dto.WinningStatDto
import kotlin.math.floor

object BuyLottoOutputView {
    private const val DIVIDING = "\n"

    fun showAllBoughtTickets(boughtTickets: List<LottoTicket>): String {
        var result = ""
        result += "${boughtTickets.size}를 구매했습니다" + DIVIDING
        boughtTickets.forEach { lottoTicket ->
            result += lottoTicket
                .lottoTicketNumbers.value.map { it.value }.sorted()
                .joinToString(prefix = "[", postfix = "]") + DIVIDING
        }
        result += DIVIDING
        return result
    }

    fun showWinningStartLabel(): String {
        return """당첨통계
---------"""
    }

    fun showAllWinningStat(winningStatDTOs: List<WinningStatDto>): String {
        return winningStatDTOs.joinToString(separator = DIVIDING) { winningStatDto -> showWiningStat(winningStatDto) }
    }

    private fun showWiningStat(winningStatDto: WinningStatDto): String {
        return "${winningStatDto.lottoPrizePolicy.wonMatchedCount}개 일치 (${winningStatDto.lottoPrizePolicy.wonPrize.value})-${winningStatDto.totalWinningCount}개"
    }

    fun showEarningsRate(boughtTicketTotalMoney: Money, winningStatDTOs: List<WinningStatDto>): String {
        var totalPrizeInt = 0
        winningStatDTOs.forEach { winningStatDto -> totalPrizeInt += winningStatDto.totalWinningPrize.value }
        val earningsRate = floor((totalPrizeInt.toDouble() / boughtTicketTotalMoney.value) * 100) / 100
        return "총 수익률은 ${earningsRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    }
}
