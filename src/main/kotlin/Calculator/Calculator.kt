package Calculator

import java.lang.IndexOutOfBoundsException

const val FIRST_PREFIX = "//"
const val SECOND_PREFIX = "\n"
const val CUSTOM_SPLITTER_LOCATION = 2

object Calculator {

    fun calculate(numbers: List<Int>): Int {
        return numbers.sum()
    }

    fun getNumbers(numbersInput: String?): String? {
        require(!numbersInput.isNullOrBlank()) { "숫자를 입력해주세요." }
        return numbersInput
    }

    fun hasCustomSplitter(numbersInput: String): Boolean {
        return try {
            numbersInput.startsWith(FIRST_PREFIX)
                .and(numbersInput.substring(CUSTOM_SPLITTER_LOCATION + 1).startsWith(SECOND_PREFIX))
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }

    fun getCustomSplitter(numbersInput: String): Char {
        try {
            return numbersInput[CUSTOM_SPLITTER_LOCATION]
        } catch (e: IndexOutOfBoundsException) {
            throw IndexOutOfBoundsException("입력값을 확인하세요.")
        }
    }
}
