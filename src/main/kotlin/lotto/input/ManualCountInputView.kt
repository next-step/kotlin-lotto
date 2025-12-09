package lotto.input

import lotto.LottoMessageConst.Companion.ERROR_MESSAGE_EMPTY
import lotto.domain.ManualCount
import lotto.domain.Money

class ManualCountInputView() {
    companion object {
        private const val ERROR_MESSAGE_INVALID = "올바른 수동 구매수를 입력하세요"

        fun process(
            money: Money,
            input: String?,
        ): ManualCount {
            return ManualCount(money, parseAndValidate(input))
        }

        fun process(money: Money): ManualCount {
            while (true) {
                try {
                    println("수동으로 구매할 로또 수를 입력해 주세요.")
                    return process(money, readln())
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(count: String?): Int {
            requireNotNull(count) { ERROR_MESSAGE_EMPTY }
            require(count.isNotBlank()) { ERROR_MESSAGE_EMPTY }
            return requireNotNull(count.toIntOrNull()) { ERROR_MESSAGE_INVALID }
        }
    }
}
