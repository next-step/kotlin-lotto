package Calculator

import java.lang.IndexOutOfBoundsException

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
            numbersInput.startsWith("//").and(numbersInput.substring(3).startsWith("\n"))
        } catch (e: IndexOutOfBoundsException) {
            false
        }
    }
}
