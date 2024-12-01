package lotto.domain

import lotto.domain.LottoTicket.Companion.INVALID_WINNER_NUMBERS_RANGE_MESSAGE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MAX_VALUE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MIN_VALUE

data class LottoWinnerNumbers(val winnerNumbers: Set<Int>) {
    init {
        require(winnerNumbers.size == LOTTO_NUMBER_COUNT) { INVALID_WINNER_NUMBERS_COUNT_MESSAGE }
        require((LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).toSet().containsAll(winnerNumbers)) {
            INVALID_WINNER_NUMBERS_RANGE_MESSAGE
        }
    }

    fun resultLottoPayout(purchasedLottoTickets: PurchasedLottoTickets): PurchasedLottoResults {
        val threeNumberMatchs = mutableListOf<LottoTicket>()
        val fourNumberMatchs = mutableListOf<LottoTicket>()
        val fiveNumberMatchs = mutableListOf<LottoTicket>()
        val sixNumberMatchs = mutableListOf<LottoTicket>()

        purchasedLottoTickets.purchasedLottoTickets.forEach { lottoTicket ->
            numberMatchApply(
                lottoTicket = lottoTicket,
                threeNumberMatchs = threeNumberMatchs,
                fourNumberMatchs = fourNumberMatchs,
                fiveNumberMatchs = fiveNumberMatchs,
                sixNumberMatchs = sixNumberMatchs,
            )
        }

        return PurchasedLottoResults(
            purchasedCount = purchasedLottoTickets.purchasedCount,
            threeNumberMatchCount = threeNumberMatchs.size,
            fourNumberMatchCount = fourNumberMatchs.size,
            fiveNumberMatchCount = fiveNumberMatchs.size,
            sixNumberMatchCount = sixNumberMatchs.size,
        )
    }

    private fun numberMatchApply(
        lottoTicket: LottoTicket,
        threeNumberMatchs: MutableList<LottoTicket>,
        fourNumberMatchs: MutableList<LottoTicket>,
        fiveNumberMatchs: MutableList<LottoTicket>,
        sixNumberMatchs: MutableList<LottoTicket>,
    ) {
        val lottoNumberMatchPayout = checkLottoWinnerNumbersMatchPayout(lottoTicket)

        when (lottoNumberMatchPayout) {
            LottoNumberMatchPayout.THREE_NUMBER_MATCH -> threeNumberMatchs.add(lottoTicket)
            LottoNumberMatchPayout.FOUR_NUMBER_MATCH -> fourNumberMatchs.add(lottoTicket)
            LottoNumberMatchPayout.FIVE_NUMBER_MATCH -> fiveNumberMatchs.add(lottoTicket)
            LottoNumberMatchPayout.SIX_NUMBER_MATCH -> sixNumberMatchs.add(lottoTicket)
            else -> return
        }
    }

    private fun checkLottoWinnerNumbersMatchPayout(lottoTicket: LottoTicket,): LottoNumberMatchPayout {
        val matchCount = lottoTicket.lottoNumbers.intersect(winnerNumbers).size
        return LottoNumberMatchPayout.byMatchCount(matchCount)
    }
    companion object {
        const val INVALID_WINNER_NUMBERS_COUNT_MESSAGE: String = "로또 당첨 번호 개수는 6개여야 합니다"
    }
}
