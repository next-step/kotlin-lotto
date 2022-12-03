package lotto.domain

class Ticket(
    private val numbers: List<Int> = LOTTO_RANGE.shuffled().take(LOTTO_COUNT).sorted()
) {
    init {
        valid(numbers)
    }

    private fun valid(numbers: List<Int>) {
        if (numbers.size != LOTTO_COUNT) throw IllegalArgumentException("로또 번호 6개에 적합하지 않습니다")
        if (numbers.toSet().size != LOTTO_COUNT) throw IllegalArgumentException("중복된 로또 번호가 존재합니다")
    }

    fun getNumbers() = this.numbers

    fun getMatchingNumbersCount(winnerNumbers: List<Int>) =
        getNumbers().filter { winnerNumbers.contains(it) }.size

    companion object {
        val LOTTO_RANGE = 1..45
        const val LOTTO_COUNT = 6
    }
}
