package lotto.model.number

class WinningNumber private constructor(winningNumber: Int) : LottoNumber(winningNumber) {
    companion object {
        private val WINNING_NUMBERS = (MINIMUM..MAXIMUM).map { WinningNumber(it) }

        fun get(winningNumber: Int): WinningNumber {
            validate(winningNumber)

            return WINNING_NUMBERS[winningNumber - 1]
        }
    }
}
