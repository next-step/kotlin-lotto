package calculator

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class StringCalculator private constructor(
    private val delimiter: String = "[,:]",
    private val text: String,
) {
    fun execute(): Int {
        if (this.text.isEmpty()) {
            return 0
        }

        if (this.text.toIntOrNull() != null) {
            return this.text.toInt()
        }

        return this.text
            .split(delimiter.toRegex())
            .sumOf {
                val number = it.toIntOrNull()
                    ?: throw IllegalArgumentException("계산할 값은 정수로 입력해야합니다. text: ${this.text}")
                require(number >= 0) { "음수는 계산이 불가능합니다. 0이상의 정수를 입력해주세요.  text: ${this.text}" }
                number
            }
    }

    companion object {
        private const val CUSTOM_DELIMITER_INDEX = 1
        private const val TEXT_INDEX = 2
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")

        fun of(text: String): StringCalculator {
            val result = CUSTOM_DELIMITER_REGEX.find(text)
            if (haveCustomDelimiter(result)) {
                require(result.groupValues[CUSTOM_DELIMITER_INDEX].toIntOrNull() == null) { "구분자는 숫자로 지정할 수 없습니다." }
                return StringCalculator(
                    delimiter = result.groupValues[CUSTOM_DELIMITER_INDEX],
                    text = result.groupValues[TEXT_INDEX],
                )
            }
            return StringCalculator(text = text)
        }

        @OptIn(ExperimentalContracts::class)
        private fun haveCustomDelimiter(result: MatchResult?): Boolean {
            contract { returns(true) implies (result != null) }
            return result != null
        }
    }
}
