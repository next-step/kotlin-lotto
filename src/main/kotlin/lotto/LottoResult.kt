package lotto

class LottoResult(private val lottoPrize: LottoPrize, matchingNumber: List<Int>) {
    private val count = matchingNumber.count { lottoPrize.prize == it }

    fun prizeAndCountPair() = Pair(lottoPrize.prize, count)
}
