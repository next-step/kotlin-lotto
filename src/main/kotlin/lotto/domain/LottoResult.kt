package lotto.domain

class LottoResult(private val lottoPrize: LottoPrize, private val matchingCount: Int) {

    fun prizeAndCountPair() = Pair(lottoPrize, matchingCount)

    companion object {
        fun decideLottoPrize(lottoPrize: LottoPrize, matchingNumber: List<Pair<Int, Boolean>>) =
            LottoResult(lottoPrize, matchingNumber.count { (matchingNumberCounts, isBonus) ->
                LottoPrize.valueOf(matchingNumberCounts, isBonus) == lottoPrize
            })
    }
}
