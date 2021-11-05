package lotto.domain

class LottoResult(private val lottoPrize: LottoPrize, private val matchingCount: Int) {

    fun prizeAndCountPair() = Pair(lottoPrize, matchingCount)

    companion object {
        fun decideLottoPrize(lottoPrize: LottoPrize, matchingNumber: List<MatchingWinningNumber>) =
            LottoResult(lottoPrize, matchingNumber.count {
                LottoPrize.valueOf(it.winningNumberCount, it.bonusNumber) == lottoPrize
            })
    }
}
