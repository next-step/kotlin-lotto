package lotto.model.number

class WinningNumber internal constructor(winningNumber: Int) : LottoNumber(winningNumber) {
    companion object {
        fun get(winningNumber: Int): WinningNumber {
            return LottoNumber.get(winningNumber) as WinningNumber
        }
    }
}
