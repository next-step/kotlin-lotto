package lotto.domain

import lotto.dto.WinningStatDto

class LottoPrizeManager {
    private val lottoPrizePolices: MutableList<LottoPrizePolicy> = mutableListOf()
    val polices
        get() = lottoPrizePolices.toList()

    fun addUniquePolicy(prizePolicy: LottoPrizePolicy) {
        validateUniqueItem(prizePolicy)
        lottoPrizePolices.add(prizePolicy)
    }

    fun getWinningStats(
        lottoTickets: List<LottoTicket>,
        winningLottoNumbers: WinningLottoNumbers
    ): List<WinningStatDto> {
        return lottoPrizePolices.map { lottoPrizePolicy ->
            WinningStatDto(
                lottoPrizePolicy,
                lottoTickets.count { lottoTicket -> lottoPrizePolicy.isWon(lottoTicket, winningLottoNumbers) }
            )
        }
    }

    private fun validateUniqueItem(prizePolicy: LottoPrizePolicy) {
        lottoPrizePolices.forEach {
            require(it != prizePolicy) { "동일한 당첨 정책이 존재합니다" }
        }
    }
}
