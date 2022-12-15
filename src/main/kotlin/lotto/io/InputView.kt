package lotto.io

import lotto.domain.BuyAmount
import lotto.domain.WinningNumber
import lotto.extension.toInt
import lotto.extension.toIntSet

object InputView {
    private const val BUY_AMOUNT_INPUT_GUIDE_MESSAGE = "구입 금액을 입력하세요"
    private const val WINNING_NUMBER_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요."

    private const val COMMA = ","

    fun inputBuyAmount(): BuyAmount {
        var buyAmount: BuyAmount? = null
        do {
            println(BUY_AMOUNT_INPUT_GUIDE_MESSAGE)
            try {
                buyAmount = BuyAmount.of(readln())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (buyAmount == null)
        return buyAmount
    }

    fun inputWinningNumber(): WinningNumber {
        var winningNumber: WinningNumber? = null
        do {
            println(WINNING_NUMBER_INPUT_GUIDE_MESSAGE)
            try {
                val winningLotto = inputWinningNumberSet()
                val bonusNumber = inputBonusNumber()
                winningNumber = WinningNumber.of(winningLotto, bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (winningNumber == null)
        return winningNumber
    }

    private fun inputWinningNumberSet(): Set<Int> = readln().split(COMMA).toIntSet()

    private fun inputBonusNumber(): Int {
        println(BONUS_NUMBER_INPUT_GUIDE_MESSAGE)
        return readln().toInt()
    }
}
