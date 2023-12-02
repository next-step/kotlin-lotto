package specific.lotto.domain

data class Ticket(val numbers: Set<Number>) {

    init {
        require(numbers.size == NUMBERS_SIZE) { "'numbers' must be $NUMBERS_SIZE numbers" }
    }

    fun countSameNumber(winningNumbers: WinningNumbers): Int {
        return numbers.count { winningNumbers.isMatchMainNumber(it) }
    }

    fun hasBonusNumber(winningNumbers: WinningNumbers): Boolean {
        return numbers.contains(winningNumbers.bonusNumber)
    }

    fun getSortedNumbers() = numbers.sortedBy { it.value }

    companion object {
        const val PRICE = 1000L
        const val NUMBERS_SIZE = 6

        fun issueManually(markedNumbers: MarkedNumbers) = Ticket(markedNumbers.values)
    }
}

@JvmInline
value class MarkedNumbers(val values: Set<Number>) {
    constructor(values: List<Int>) : this(values = values.map(::Number).toSet())
}
