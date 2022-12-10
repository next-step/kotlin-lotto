package step2.lotto.domain

class PlayInfo private constructor(buyAmount: Int, val winningNumber: WinningNumber) {
    val tryCount: Int = buyAmount / TRY_COUNT_DIVISOR

    companion object {
        private const val TRY_COUNT_DIVISOR = 1_000
        fun of(buyAmount: Int, winningNumber: WinningNumber): PlayInfo = PlayInfo(buyAmount, winningNumber)
    }
}
