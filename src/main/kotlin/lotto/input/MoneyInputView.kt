package lotto.input

import lotto.LottoMessageConst.Companion.ERROR_MESSAGE_EMPTY
import lotto.domain.Money

class MoneyInputView() {
    companion object {
        private const val ERROR_MESSAGE_INVALID = "올바른 금액을 입력하세요"

        fun process(input: String?): Money {
            return Money(parseAndValidate(input))
        }

        fun process(): Money {
            while (true) {
                try {
                    println("구입금액을 입력해 주세요.")
                    return process(readln())
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(price: String?): Int {
            requireNotNull(price) { ERROR_MESSAGE_EMPTY }
            require(price.isNotBlank()) { ERROR_MESSAGE_EMPTY }
            return requireNotNull(price.toIntOrNull()) { ERROR_MESSAGE_INVALID }
        }
    }
}
