package lotto.model

import lotto.controller.WinnerTicket

class WinningCalculator {
    fun generateWinningStatistics(
        lottoTickets: List<LottoTicket>,
        winnerTicket: LottoTicket,
        bonusNumber: Int
    ): WinningStatistics {
        val results = mutableListOf<Rank>()

        for (lottoTicket in lottoTickets) {
            val restNumber = lottoTicket.values.toSet().subtract(winnerTicket.values.toSet())
            val findingBonusNumber = restNumber.find { it == bonusNumber } ?: 0

            results.add(
                WinnerTicket().getRank(lottoTicket, winnerTicket, findingBonusNumber)
            )
        }

        return WinningStatistics(results)
    }
}
