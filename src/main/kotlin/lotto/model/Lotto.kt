package lotto.model

class Lotto {
    var lottoPrize: LottoPrize = LottoPrize.NONE_PRIZE
    val purchasedLottoNumbers: List<Int> = LOTTO_NUMBERS.shuffled().take(LOTTO_NUMBER_COUNT).sorted()

    private fun match(lastWeekWinningNumbers: List<Int>): Int {
        val matchingNumbers = purchasedLottoNumbers.intersect(lastWeekWinningNumbers.toSet()).size
        return matchingNumbers
    }

    fun setLottoPrize(lastWeekWinningNumbers: List<Int>, lastWeekBonusNumber: Int): LottoPrize {
        val matchingNumbers = match(lastWeekWinningNumbers)
        val bonusBallMatching: Int =
            if (purchasedLottoNumbers.contains(lastWeekBonusNumber)) CONTAIN_BALL else NOT_CONTAIN_BALL
        lottoPrize = LottoPrize.getLottoPrize(matchingNumbers, bonusBallMatching)
        return lottoPrize
    }

    companion object {
        private val LOTTO_NUMBERS: List<Int> = (1..45).toList()
        private const val LOTTO_NUMBER_COUNT = 6
        private const val CONTAIN_BALL = 1
        private const val NOT_CONTAIN_BALL = 0
    }
}
