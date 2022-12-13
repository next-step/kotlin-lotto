package lotto.model

class WinningNumbers(private val numbers: Lotto) {
    fun matchCount(lotto: Lotto): Int {
        return numbers.getCountThatMatches(lotto)
    }
}
