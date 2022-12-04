package lotto.util

object Parser {
    const val LOTTO_NUMBER_SIZE_ERROR = "로또 번호는 6개의 숫자로 이루어져 있어요. (중복 불가)"
    private const val EMPTY_STRING = ""
    private val REPLACE_REGEX = "\\s+|\\[|\\]".toRegex()
    private val SPLIT_REGEX = ",".toRegex()

    fun parse(rawString: String): List<Int> {
        val removeSpaceStr = rawString.replace(REPLACE_REGEX, EMPTY_STRING)
        val splitStr = removeSpaceStr.split(SPLIT_REGEX)
        return splitStr.map { it.toInt() }.apply { validateLottoNumber(this) }
    }

    private fun validateLottoNumber(result: List<Int>) {
        require(result.toSet().size == 6) { LOTTO_NUMBER_SIZE_ERROR }
    }
}
