package lotto.domain

class LottoResult(private val lottoPrize: LottoPrize, matchingNumber: List<Int>) {
    private val count = matchingNumber.count { lottoPrize.matchingNumberCount == it }

    fun prizeAndCountPair() = Pair(lottoPrize, count)
}
