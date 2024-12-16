package lotto.domain

import lotto.domain.LottoPurchaseCalculator.DEFAULT_LOTTO_PRICE

data class PurchasedLottoResults(
    val purchasedCount: Int,
    val firstRankCount: Int,
    val secondRankCount: Int,
    val thirdRankCount: Int,
    val fourthRankCount: Int,
    val fifthRankCount: Int,
) {
    init {
        require(purchasedCount >= PURCHASED_COUNT_MIN_VALUE) { INVALID_PURCHASED_COUNT_MESSAGE }
        require(firstRankCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(secondRankCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(thirdRankCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fourthRankCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(fifthRankCount >= LOTTO_MATCH_COUNT_MIN_VALUE) { INVALID_LOTTO_MATCH_COUNT_MESSAGE }
        require(
            purchasedCount >=
                firstRankCount + secondRankCount + thirdRankCount + fourthRankCount + fifthRankCount,
        ) { INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE }
    }

    fun getProfitMargin(): Double {
        val totalPayout =
            firstRankCount * LottoWinnerRank.FIRST.winningMoney +
                secondRankCount * LottoWinnerRank.SECOND.winningMoney +
                thirdRankCount * LottoWinnerRank.THIRD.winningMoney +
                fourthRankCount * LottoWinnerRank.FOURTH.winningMoney +
                fifthRankCount * LottoWinnerRank.FIFTH.winningMoney

        return totalPayout.toDouble() / (purchasedCount * DEFAULT_LOTTO_PRICE).toDouble()
    }

    companion object {
        const val LOTTO_MATCH_COUNT_MIN_VALUE: Int = 0
        const val PURCHASED_COUNT_MIN_VALUE: Int = 1
        const val INVALID_PURCHASED_COUNT_MESSAGE: String = "구입한 로또 개수가 올바르지 않습니다"
        const val INVALID_LOTTO_MATCH_COUNT_MESSAGE: String = "로또 당첨 번호 매치 결과는 0 이상 이어야합니다"
        const val INVALID_PURCHASED_COUNT_LOTTO_MATCH_COUNT_MESSAGE: String = "당첨된 내역의 합이 구매한 개수보다 많을 수 없습니다"
    }
}
