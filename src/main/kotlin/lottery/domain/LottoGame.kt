package lottery.domain

import lottery.validator.InputValidator

class LottoGame(price: String) {
    val amount: Int

    init {
        val inputPrice: Int = InputValidator.validateAmount(price)
        amount = inputPrice.div(LOTTERY_PRICE)
    }

    companion object {
        private const val LOTTERY_PRICE = 1000
    }
}
