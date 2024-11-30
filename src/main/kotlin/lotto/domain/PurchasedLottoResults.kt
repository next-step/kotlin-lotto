package lotto.domain

import lotto.domain.LottoNumberMatchPayout.FIVE_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.FOUR_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.SIX_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.THREE_NUMBER_MATCH
import lotto.domain.LottoTicketIssuer.DEFAULT_LOTTO_PRICE
import lotto.domain.PurchasedLottoTickets.Companion.INVALID_PURCHASED_COUNT_MESSAGE
import lotto.domain.PurchasedLottoTickets.Companion.PURCHASED_COUNT_MIN_VALUE

data class PurchasedLottoResults(
    val purchasedCount: Int,
    val threeNumberMatchCount: Int,
    val fourNumberMatchCount: Int,
    val fiveNumberMatchCount: Int,
    val sixNumberMatchCount: Int,
) {
    init {
        require(purchasedCount >= PURCHASED_COUNT_MIN_VALUE) { INVALID_PURCHASED_COUNT_MESSAGE }
        require(threeNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fourNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fiveNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(sixNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(
            purchasedCount >=
                threeNumberMatchCount + fourNumberMatchCount + fiveNumberMatchCount + sixNumberMatchCount,
        ) { INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE }
    }

    fun getProfitMargin(): Double {
        val totalPayout =
            threeNumberMatchCount * LottoNumberMatchPayout.matchCountToPayout(THREE_NUMBER_MATCH) +
                fourNumberMatchCount * LottoNumberMatchPayout.matchCountToPayout(FOUR_NUMBER_MATCH) +
                fiveNumberMatchCount * LottoNumberMatchPayout.matchCountToPayout(FIVE_NUMBER_MATCH) +
                sixNumberMatchCount * LottoNumberMatchPayout.matchCountToPayout(SIX_NUMBER_MATCH)

        return totalPayout.toDouble() / (purchasedCount * DEFAULT_LOTTO_PRICE).toDouble()
    }

    companion object {
        const val LOTTO_MATCH_COUNT_MIN_VALUE: Int = 0
        const val INVALID_LOTTO_MATCH_COUNT_MESSAGE: String = "로또 당첨 번호 매치 결과는 0 이상 이어야합니다"
        const val INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE: String = "당첨된 내역의 합이 구매한 개수보다 많을 수 없습니다"
    }
}
