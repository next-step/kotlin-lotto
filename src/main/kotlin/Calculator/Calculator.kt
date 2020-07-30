package Calculator

import java.lang.IndexOutOfBoundsException
import java.lang.StringBuilder

const val FIRST_PREFIX = "//"
const val SECOND_PREFIX = "\n"
const val CUSTOM_SPLITTER_LOCATION = 2

object Calculator {

    private val defaultSplitters = listOf(",", ":")

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

    @Throws(IndexOutOfBoundsException::class)
    fun getSplitters(numbersInput: String, hasCustomSplitter: Boolean): List<String> {
        if (hasCustomSplitter) {
            return listOf(numbersInput[CUSTOM_SPLITTER_LOCATION].toString())
        }
        return defaultSplitters
    }

    fun hasOnlyValidString(numbersInput: String, splitters: List<String>): Boolean {
        val pattern = StringBuilder("[0-9")
        splitters.forEach { pattern.append("|" + it) }
        pattern.append("]*")

        return numbersInput.replace(FIRST_PREFIX, SECOND_PREFIX).matches(Regex(pattern.toString()))
    }

    fun checkEndString(numbersInput: String): Boolean {
        return numbersInput.last().toString().matches(Regex("[0-9]"))
    }

    fun parsing(numbersInput: String): List<Int> {
        if (defaultSplitters.size == 2) {
            return numbersInput.replace(defaultSplitters[1], defaultSplitters[0]).split(defaultSplitters[0])
                .map { it.toInt() }
        }
        return numbersInput.split(defaultSplitters[0]).map { it.toInt() }
    }
}
