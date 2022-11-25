package lotto.domain

class Ticket(
    private var numbers: List<Int> = LOTTO_RANGE.shuffled().take(LOTTO_COUNT).sorted()
) {

    fun getNumbers() = this.numbers

    fun getMatchingNumbersCount(winnerNumbers: List<Int>) = getNumbers().filter { winnerNumbers.contains(it) }.size

    companion object {
        val LOTTO_RANGE = 1..45
        const val LOTTO_COUNT = 6
    }
}
