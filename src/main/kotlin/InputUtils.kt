import java.lang.NumberFormatException
import java.lang.RuntimeException

private const val DELIMITER_1 = ","
private const val DELIMITER_2 = ";"
private const val ZERO = "0"
private const val PREFIX_CUSTOM = "//"
private const val SUFFIX_CUSTOM = "\\n"
private const val ZERO_INDEX_WITHOUT_PREFIX = 3
private const val ZERO_INDEX_OF_ONLY_INPUT = 5
private const val INDEX_OF_CUSTOM = 2

object InputUtils {
    fun split(input: String): List<String> {
        if (doesHaveCustom(input)) {
            return splitByCustom(input)
        }

        if (input.isBlank()) {
            return listOf(ZERO)
        }

        return input.split(DELIMITER_1)
            .flatMap { it.split(DELIMITER_2) }
    }

    private fun splitByCustom(input: String): List<String> {
        val customDelimiter = input.elementAt(INDEX_OF_CUSTOM)
        return input.substring(ZERO_INDEX_OF_ONLY_INPUT)
            .split(customDelimiter)
    }

    private fun doesHaveCustom(input: String): Boolean {
        return doesHavePrefixForCustom(input) && doesHaveSuffixForCustom(input)
    }

    private fun doesHavePrefixForCustom(input: String): Boolean {
        return input.startsWith(PREFIX_CUSTOM)
    }

    private fun doesHaveSuffixForCustom(input: String): Boolean {
        return input.substring(ZERO_INDEX_WITHOUT_PREFIX).startsWith(SUFFIX_CUSTOM)
    }

    fun convertToNumber(splitInput: List<String>): List<Int> {
        try {
            val parsedValues = splitInput.map(Integer::parseInt)

            if (hasNegative(parsedValues)) {
                throw RuntimeException("음수는 허용되지 않습니다.")
            }
            return parsedValues
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자만 허용됩니다.")
        }
    }

    private fun hasNegative(parsedValue: List<Int>): Boolean {
        return parsedValue.any { it < 0 }
    }
}
