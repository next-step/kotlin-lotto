package lotto.model

class WinningNumbers(val numbers: List<LottoNumber>) {
    fun matchCount(lotto: Lotto): Int {
        return 0
    }

    companion object {
        fun of(i: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int): WinningNumbers {
            return WinningNumbers(listOf())
        }
    }

}
