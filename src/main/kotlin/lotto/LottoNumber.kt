package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER)
    }

    fun isEqualTo(other: Int): Boolean {
        return value == other
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
