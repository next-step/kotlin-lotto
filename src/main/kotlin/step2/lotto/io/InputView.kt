package step2.lotto.io

import step2.lotto.domain.BuyAmount
import step2.lotto.domain.WinningNumber

object InputView {
    private const val BUY_AMOUNT_INPUT_GUIDE_MESSAGE = "구입 금액을 입력하세요"
    private const val WINNING_NUMBER_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."

    fun inputBuyAmount(): BuyAmount {
        var buyAmount: BuyAmount? = null
        do {
            println(BUY_AMOUNT_INPUT_GUIDE_MESSAGE)
            try {
                buyAmount = BuyAmount.of(readLine()!!)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (buyAmount == null)
        return buyAmount
    }

    fun inputWinningNumber(): WinningNumber {
        var winningNumber: WinningNumber?
        do {
            println(WINNING_NUMBER_INPUT_GUIDE_MESSAGE)
            winningNumber = WinningNumber.ofStrings(inputNumberSet())
        } while (winningNumber == null)
        return winningNumber
    }

    private const val WINNING_NUMBER_SET_SIZE = 6

    private fun inputNumberSet() =
        List(WINNING_NUMBER_SET_SIZE) { readLine()!! }
}
