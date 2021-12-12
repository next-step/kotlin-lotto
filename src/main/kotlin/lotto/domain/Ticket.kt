package lotto.domain

/**
 *
 * @author Leo
 */
class Ticket(val numbers: List<LottoNumber>) {

    init {
        require(numbers.toMutableSet().size == LOTTO_NUMBER_COUNT)
    }

    fun getRank(winningNumber: List<Int>, bonusNumber: Int): Rank {
        return this.find(winningNumber, bonusNumber) ?: Rank.NONE
    }

    fun getNumbers(): String {
        return numbers.map { it.number }
            .joinToString(separator = NUMBERS_SEPERATOR, prefix = NUMBERS_BRACKET_START, postfix = NUMBERS_BRACKET_END)
    }

    private fun find(winningNumber: List<Int>, bonusNumber: Int): Rank? {
        val sameNumbers = numbers.filter { winningNumber.contains(it.number) }
        val isBonusWin = numbers.map { it.number }.contains(bonusNumber)
        return Rank.rank(sameNumbers.map { it.number }, isBonusWin)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        private const val NUMBERS_BRACKET_START = "["
        private const val NUMBERS_BRACKET_END = "]"
        private const val NUMBERS_SEPERATOR = ","
    }

}
