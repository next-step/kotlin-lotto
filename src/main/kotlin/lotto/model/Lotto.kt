package lotto.model

class Lotto {
    private val lottoNumbers: List<Int> = (1..45).toList()

    var lottoPrize: LottoPrize = LottoPrize.NONE_PRIZE
    val winningNumber: List<Int> = lottoNumbers.shuffled().take(6).sorted()

    fun setLottoPrize(lastWeekWinningNumbers: List<Int>): LottoPrize {
        val matchingNumbers = winningNumber.intersect(lastWeekWinningNumbers.toSet()).size
        lottoPrize = LottoPrize.getLottoPrize(matchingNumbers)
        return lottoPrize
    }
}
