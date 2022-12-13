package lotto.model

class WinningNumbers(input: Set<LottoNumber>) {
    private val numbers = Lotto(input)

    fun matchCount(lotto: Lotto): Int {
        return numbers.getCountThatMatches(lotto)
    }

    companion object {
        fun of(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(numbers.map { LottoNumber(it) }.toSet())
        }
    }
}
