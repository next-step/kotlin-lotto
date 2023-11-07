package lotto.domain

class Lotto(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_COUNT) { "Lotto numbers should be $NUMBER_COUNT numbers." }
    }

    fun getMatchedNumberCount(winningNumbers: WinningNumbers): Int {
        return numbers.toSet()
            .intersect(winningNumbers.numbers.toSet())
            .count()
    }

    companion object {
        const val PRICE = 1000L
        const val NUMBER_COUNT = 6
    }
}
