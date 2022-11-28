package lotto

class Parser {
    fun parse(value: String): List<LottoNumber> {
        val splitStr = value.replace(" ", "").split(",")
        return toLottoNumbers(splitStr)
    }

    private fun toLottoNumbers(str: List<String>): List<LottoNumber> {
        val result = mutableListOf<LottoNumber>()
        for (s in str) {
            result.add(LottoNumber(s.toInt()))
        }
        return result
    }
}
