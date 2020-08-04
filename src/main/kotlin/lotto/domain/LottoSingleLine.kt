package lotto.domain

private val LOTTO_NUMBER_RANGE = 1..45
private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.toList()
private const val LOTTO_PICK_COUNT = 6

class LottoSingleLine {
    private val lottoNumbers = createLine()

    fun getNumbers(): List<Int> {
        return lottoNumbers
    }

    fun matching(result: List<Int>): Int {
        return result.filter { lottoNumbers.contains(it) }.size
    }

    private fun createLine(): List<Int> {
        return LOTTO_NUMBERS.shuffled().take(LOTTO_PICK_COUNT).sorted()
    }
}
