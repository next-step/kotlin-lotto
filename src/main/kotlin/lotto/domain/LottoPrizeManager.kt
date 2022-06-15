package lotto.domain

import lotto.dto.WinningStatDto

class LottoPrizeManager {
    private val lottoRanks: List<LottoRank> = LottoRank.values().toList()

    fun getWinningStats(
        lottoTickets: List<LottoTicket>,
        winningLottoNumbers: WinningLottoNumbers
    ): List<WinningStatDto> {
        return lottoRanks.map { lottoRank ->
            WinningStatDto(
                lottoRank,
                lottoTickets.count { lottoTicket -> lottoRank.isWon(lottoTicket, winningLottoNumbers) }
            )
        }
    }
}
