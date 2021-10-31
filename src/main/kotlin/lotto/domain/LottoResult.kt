package lotto.domain

data class LottoResult(private val lottoPrize: LottoPrize, private val matchingCount: Int) {

    fun prizeAndCountPair() = Pair(lottoPrize, matchingCount)

    companion object {
        fun matchingNumber(lottoPrize: LottoPrize, matchingNumber: List<Int>) =
            LottoResult(lottoPrize, matchingNumber.count { lottoPrize.matchingNumberCount == it })
    }
}
