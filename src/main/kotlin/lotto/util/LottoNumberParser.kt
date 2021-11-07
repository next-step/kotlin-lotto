package lotto.util

object LottoNumberParser {

    private const val SEPARATOR = ","
    private const val LOTTO_NUMBER_SIZE = 6

    fun parse(input: String): List<Int> {
        val parse = input
            .split(SEPARATOR)
            .map { winningNumber ->
                winningNumber.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.")
            }

        require(parse.size == LOTTO_NUMBER_SIZE) { "6개의 숫자로 이루어져야 합니다." }

        return parse
    }
}
