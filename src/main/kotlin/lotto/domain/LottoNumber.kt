package lotto.domain

@JvmInline
value class LottoNumber(
    val number: Int,
) {
    init {
        require(number in (MIN_NUMBER..MAX_NUMBER)) { "Lotto number should be in range of $MIN_NUMBER~$MAX_NUMBER." }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
