package step2.lotto.domain

class PlayInfo private constructor(buyAmount: BuyAmount, val winningNumber: WinningNumber) {
    val buyAmount: Int = buyAmount.value
    val tryCount: Int = buyAmount.tryCount

    companion object {
        fun of(buyAmount: BuyAmount, winningNumber: WinningNumber): PlayInfo =
            PlayInfo(buyAmount, winningNumber)
    }
}
