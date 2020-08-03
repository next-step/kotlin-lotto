package lotto.domain

private val LOTTO_NUMBER_LIST = (1..45).toList()

class LottoSingleLine {
    private val lottoNumbers = createLine()
    private var matchCount = 0
        get() = matchCount

    fun matchResult(result: List<Int>) {
        result.forEach {
            if (lottoNumbers.contains(it)) matchCount++
        }
    }

    private fun createLine(): List<Int> {
        return LOTTO_NUMBER_LIST.shuffled().take(6).sorted()
    }
}
