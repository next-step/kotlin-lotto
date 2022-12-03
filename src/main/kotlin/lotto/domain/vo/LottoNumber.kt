package lotto.domain.vo

@JvmInline
value class LottoNumber(private val number: Int) {
    init {
        require(number in MIN_VALUE..MAX_VALUE) { "lotto number should be between $MIN_VALUE and $MAX_VALUE" }
    }

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = 45
    }
}
