package lotto.domain

private val LOTTO_NUMBER_LIST = (1..45).toList()

class LottoSingleLine {
    val lottoNumbers = createLine()

    private fun createLine(): List<Int> {
        return LOTTO_NUMBER_LIST.shuffled().take(6).sorted()
    }
}
