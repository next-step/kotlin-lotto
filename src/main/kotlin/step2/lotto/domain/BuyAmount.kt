package step2.lotto.domain

import step2.lotto.validator.NumberValidator.toInt

class BuyAmount private constructor(value: Int) {

    companion object {
        private const val MINIMUM_PRICE: Int = 1_000
        private const val DEFAULT_INVALID_ERROR_MESSAGE = "잘못 입력하셨습니다. [%s]"
        private const val EMPTY_INPUT_ERROR_MESSAGE = "빈값은 입력할 수 없습니다."
        private const val BLANK_INPUT_ERROR_MESSAGE = "공백은 입력할 수 없습니다."
        private const val LESS_THAN_MINIMUM_PRICE_ERROR_MESSAGE = "$DEFAULT_INVALID_ERROR_MESSAGE ${MINIMUM_PRICE}원 이상의 금액을 입력하세요."
        private const val NOT_DIVIDE_MINIMUM_PRICE_ERROR_MESSAGE = "$DEFAULT_INVALID_ERROR_MESSAGE ${MINIMUM_PRICE}원 단위의 금액을 입력하세요."

        fun of(input: String): BuyAmount {
            validateInput(input)
            val buyAmount = toAmount(input)
            return BuyAmount(buyAmount)
        }

        private fun validateInput(input: String) {
            require(input.isNotEmpty()) { EMPTY_INPUT_ERROR_MESSAGE }
            require(input.isNotBlank()) { BLANK_INPUT_ERROR_MESSAGE }
        }

        private fun toAmount(input: String): Int {
            val amount = toInt(input)
            validateAmount(amount)
            return amount
        }

        private fun validateAmount(input: Int) {
            require(isOverOrEqualThanMinimumPrice(input)) { LESS_THAN_MINIMUM_PRICE_ERROR_MESSAGE.format(input) }
            require(isDivideMinimumPrice(input)) { NOT_DIVIDE_MINIMUM_PRICE_ERROR_MESSAGE.format(input) }
        }

        private fun isOverOrEqualThanMinimumPrice(input: Int): Boolean = input >= MINIMUM_PRICE

        private fun isDivideMinimumPrice(input: Int): Boolean = input % MINIMUM_PRICE == 0
    }
}
