package lotto.domain

import lotto.domain.LottoNumberMatchPayout.FIVE_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.FOUR_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.SIX_NUMBER_MATCH
import lotto.domain.LottoNumberMatchPayout.THREE_NUMBER_MATCH
import lotto.domain.LottoTicketIssuer.DEFAULT_LOTTO_PRICE

data class PurchasedLottoResults(
    val purchasedCount: Int,
    val threeNumberMatchCount: Int,
    val fourNumberMatchCount: Int,
    val fiveNumberMatchCount: Int,
    val sixNumberMatchCount: Int,
) {
    init {
        require(threeNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fourNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fiveNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(sixNumberMatchCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
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
    }
}
