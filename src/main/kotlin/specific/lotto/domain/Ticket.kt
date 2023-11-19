package specific.lotto.domain

data class Ticket(val numbers: Set<Number>) {

    init {
        require(numbers.size == NUMBERS_SIZE) { "'numbers' must be $NUMBERS_SIZE numbers" }
    }

    fun countSameNumber(winningSet: WinningSet): Int {
        return numbers.count { it in winningSet.numbers }
    }

    companion object {
        const val PRICE = 1000
        const val NUMBERS_SIZE = 6
    }
}
