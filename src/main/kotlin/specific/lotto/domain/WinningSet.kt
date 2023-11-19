package specific.lotto.domain

data class WinningSet(val numbers: Set<Number>) {

    init {
        require(numbers.size == NUMBERS_SIZE) { "'numbers' must be $NUMBERS_SIZE numbers" }
    }

    companion object {
        const val NUMBERS_SIZE = 6
    }
}
