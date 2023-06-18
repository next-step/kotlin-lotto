package lotto.model

class Lotto {
    private val lottoNumbers: List<Int> = (1..45).toList()

    var prizeAmount: Long = 0
        private set
    val winningNumber: List<Int> = lottoNumbers.shuffled().take(6).sorted()

    fun calculateMatchingNumbers(lastWeekWinningNumbers: List<Int>): Int {
        val matchingNumbers = winningNumber.intersect(lastWeekWinningNumbers.toSet()).size
        prizeAmount = LottoPrize.getPrizeAmount(matchingNumbers)
        return matchingNumbers
    }
}
