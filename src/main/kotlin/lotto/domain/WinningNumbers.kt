package lotto.domain

class WinningNumbers(winningNumbersText: String) {
    private val winningNumbers: Set<LottoNumber>

    init {
        winningNumbers = winningNumbersText.split(",").map { LottoNumber.from(it.toInt()) }.toSet()
        require(winningNumbers.size == LottoNumbers.LOTTO_NUMBER_COUNT)
    }

    fun rank(lotto: Lotto): Int {
        var matchCount = 0
        lotto.numbers.forEach {
            if (winningNumbers.contains(it)) {
                matchCount++
            }
        }
        return matchCount
    }

}
