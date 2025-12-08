package domain.lotto

@JvmInline
value class LottoNumber(
    val number: Int,
) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "Lotto number must be between $MIN_NUMBER and $MAX_NUMBER."
        }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
