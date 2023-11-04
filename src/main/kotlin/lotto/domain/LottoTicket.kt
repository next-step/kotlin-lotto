package lotto.domain

class LottoTicket(private val numbers: List<Int>) {
    fun getMatchingNumbersCount(winningNumbers: Set<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
