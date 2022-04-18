package lotto.util

object LottoNumbersParser {
    const val ERR_INVALID_INPUT_VALUE: String = "[ERROR] The given input string is invalid"
    private const val SEPARATOR: String = ","

    fun splitToNumbers(input: String): List<Int> =
        runCatching {
            val withoutSpace = replaceEmptySpace(input)

            return withoutSpace.split(SEPARATOR.toRegex())
                .map { it.toInt() }
                .toList()
        }.getOrElse {
            throw IllegalArgumentException(ERR_INVALID_INPUT_VALUE)
        }

    fun replaceEmptySpace(input: String) = input.replace(" ", "")
}
