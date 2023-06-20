package lotto.model

class Lotto {
    var lottoPrize: LottoPrize = LottoPrize.NONE_PRIZE
    val purchasedLottoNumbers: List<Int> = LOTTO_NUMBERS.shuffled().take(LOTTO_NUMBER_COUNT).sorted()

    fun setLottoPrize(lastWeekWinningNumbers: List<Int>): LottoPrize {
        val matchingNumbers = purchasedLottoNumbers.intersect(lastWeekWinningNumbers.toSet()).size
        lottoPrize = LottoPrize.getLottoPrize(matchingNumbers)
        return lottoPrize
    }

    companion object {
        private val LOTTO_NUMBERS: List<Int> = (1..45).toList()
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
