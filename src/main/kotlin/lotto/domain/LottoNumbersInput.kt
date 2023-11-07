package lotto.domain

class LottoNumbersInput(private val text: String) {
    val numbers: LottoNumbers

    init {
        val matchResult = Regex(SIX_NUMBERS_WITH_OPTIONAL_COMMA).find(text)
        require(matchResult != null) {
            "You need to enter six numbers separated by \",\" or \", \" as the delimiter.(ex - 1,2,3, 4, 5,6)"
        }

        val matchedString = matchResult.value

        val numbersList = matchedString.split(',').map { it.trim().toInt() }
        numbers = LottoNumbers(*numbersList.toIntArray())
    }

    companion object {
        private const val COMMA_WITH_OPTIONAL_SPACE = ", ?"
        private const val SIX_NUMBERS_WITH_OPTIONAL_COMMA = """\d+($COMMA_WITH_OPTIONAL_SPACE\d+){5}"""
    }
}