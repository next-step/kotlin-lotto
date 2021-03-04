package calculator

data class NonNegativeIntList(private val nonNegativeIntList: List<Int>) : List<Int> by nonNegativeIntList {
    init {
        require(nonNegativeIntList.find { it < 0 } == null)
    }

    companion object {
        fun of(numericStringList: List<String>): NonNegativeIntList {
            return numericStringList.map {
                it.toInt()
            }.let { NonNegativeIntList(it) }
        }
    }
}
