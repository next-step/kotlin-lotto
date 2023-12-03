package specific.lotto.domain

@JvmInline
value class Number(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { "'value' must be between $MIN_NUMBER and $MAX_NUMBER" }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        private val numberPool = (MIN_NUMBER..MAX_NUMBER).map(::Number).toList()

        fun getNumberPool() = numberPool
    }
}
