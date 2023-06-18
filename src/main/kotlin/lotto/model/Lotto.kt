package lotto.model

class Lotto {
    private val lottoNumbers: List<Int> = (1..45).toList()

    var lottoPrize: LottoPrize = LottoPrize.NONE_PRIZE
    val winningNumber: List<Int> = lottoNumbers.shuffled().take(LOTTO_NUMBER_COUNT).sorted()

    fun setLottoPrize(lastWeekWinningNumbers: List<Int>): LottoPrize {
        val matchingNumbers = winningNumber.intersect(lastWeekWinningNumbers.toSet()).size
        lottoPrize = LottoPrize.getLottoPrize(matchingNumbers)
        return lottoPrize
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
