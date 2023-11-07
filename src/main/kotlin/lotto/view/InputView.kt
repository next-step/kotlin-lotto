package lotto.view

import lotto.domain.LottoBuyingPrice

object InputView {

    private const val BUYING_PRICE_MESSAGE = "구입금액을 입력해 주세요."

    fun readBuyingPrice(): LottoBuyingPrice {
        println(BUYING_PRICE_MESSAGE)
        val userInput = readlnOrNull()
        validateIsNullOrBlank(userInput)
        validateNumeric(userInput!!)
        return LottoBuyingPrice(userInput.toInt())
    }

    private fun validateIsNullOrBlank(userInput: String?) {
        require(!userInput.isNullOrBlank()) {
            "입력값이 존재하지 않습니다."
        }
    }

    private fun validateNumeric(userInput: String) {
        require(userInput.toIntOrNull() != null) {
            "입력값이 숫자가 아닙니다."
        }
    }
}
