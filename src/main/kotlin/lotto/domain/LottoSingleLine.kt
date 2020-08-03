package lotto.domain

private val LOTTO_NUMBER_LIST = (1..45).toList()

class LottoSingleLine {
    private val lottoNumbers = createLine()

    fun getNumbers(): List<Int> {
        return lottoNumbers
    }

    fun matching(result: List<Int>): Int {
        var count = 0
        result.forEach {
            if (lottoNumbers.contains(it)) count++
        }
        return count
    }

    private fun createLine(): List<Int> {
        return LOTTO_NUMBER_LIST.shuffled().take(6).sorted()
    }
}
