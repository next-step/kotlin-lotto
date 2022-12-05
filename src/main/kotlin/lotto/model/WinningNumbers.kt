package lotto.model

class WinningNumbers(val numbers: List<LottoNumber>) {
    fun matchCount(lotto: Lotto): Int {
        return lotto.count { numbers.contains(it) }
    }

    companion object {
        fun of(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(numbers.map { LottoNumber(it) })
        }
    }

}
