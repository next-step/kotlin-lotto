package step2.lotto.io

import step2.lotto.domain.BuyAmount

object InputView {
    private const val BUY_AMOUNT_INPUT_GUIDE_MESSAGE = "구입 금액을 입력하세요"

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
}
