package lotto.domain

import lotto.domain.LottoNumberMatchPayout.FIVE_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.FOUR_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.SIX_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.THREE_NUMBER_MATCH

object LottoNumberChecker {
    fun purchasedLottoTicketsNumberCheck(
        purchasedLottoTickets: PurchasedLottoTickets,
        winnerNumbers: LottoWinnerNumbers,
    ): PurchasedLottoResults {
        val threeNumberMatchs = mutableListOf<LottoTicket>()
        val fourNumberMatchs = mutableListOf<LottoTicket>()
        val fiveNumberMatchs = mutableListOf<LottoTicket>()
        val sixNumberMatchs = mutableListOf<LottoTicket>()

        purchasedLottoTickets.purchasedLottoTickets.forEach {
                LottoTicket ->
            numberMatchApply(
                lottoTicket = LottoTicket,
                winnerNumbers = winnerNumbers,
                threeNumberMatchs = threeNumberMatchs,
                fourNumberMatchs = fourNumberMatchs,
                fiveNumberMatchs = fiveNumberMatchs,
                sixNumberMatchs = sixNumberMatchs,
            )
        }

        return PurchasedLottoResults(
            threeNumberMatchCount = threeNumberMatchs.size,
            fourNumberMatchCount = fourNumberMatchs.size,
            fiveNumberMatchCount = fiveNumberMatchs.size,
            sixNumberMatchCount = sixNumberMatchs.size,
        )
    }

    private fun numberMatchApply(
        lottoTicket: LottoTicket,
        winnerNumbers: LottoWinnerNumbers,
        threeNumberMatchs: MutableList<LottoTicket>,
        fourNumberMatchs: MutableList<LottoTicket>,
        fiveNumberMatchs: MutableList<LottoTicket>,
        sixNumberMatchs: MutableList<LottoTicket>,
    ) {
        when (matchCountCalculator(lottoTicket = lottoTicket, winnerNumbers = winnerNumbers)) {
            THREE_NUMBER_MATCH -> threeNumberMatchs.add(lottoTicket)
            FOUR_NUMBER_MATCH -> fourNumberMatchs.add(lottoTicket)
            FIVE_NUMBER_MATCH -> fiveNumberMatchs.add(lottoTicket)
            SIX_NUMBER_MATCH -> sixNumberMatchs.add(lottoTicket)
        }
    }

    private fun matchCountCalculator(
        lottoTicket: LottoTicket,
        winnerNumbers: LottoWinnerNumbers,
    ): Int {
        return lottoTicket.lottoNumbers.intersect(winnerNumbers.winnerNumbers).size
    }
}
