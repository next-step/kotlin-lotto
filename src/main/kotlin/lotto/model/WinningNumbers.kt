package lotto.model

class WinningNumbers(input: Set<LottoNumber>) {
    private val _numbers = Lotto(input)
    val numbers: Lotto
        get() = _numbers

    fun matchCount(lotto: Lotto): Int {
        return lotto.count { _numbers.contains(it) }
    }

    companion object {
        fun of(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(numbers.map { LottoNumber(it) }.toSet())
        }
    }
}
