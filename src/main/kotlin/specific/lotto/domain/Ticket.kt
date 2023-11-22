package specific.lotto.domain

data class Ticket(val numbers: Set<Number>) {
    constructor(numbers: List<Int>) : this(numbers.map { Number(it) }.toSet())

    init {
        require(numbers.size == NUMBERS_SIZE) { "'numbers' must be $NUMBERS_SIZE numbers" }
    }

    fun countSameNumber(winningNumbers: WinningNumbers): Int {
        return numbers.count { it in winningNumbers.mainNumbers.numbers }
    }

    fun hasBonusNumber(winningNumbers: WinningNumbers): Boolean {
        return numbers.contains(winningNumbers.bonusNumber)
    }

    companion object {
        const val PRICE = 1000
        const val NUMBERS_SIZE = 6
    }
}

typealias Tickets = List<Ticket>
