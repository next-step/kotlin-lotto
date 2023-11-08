package lotto.domain

@JvmInline
value class LottoCount(
    val value: Int,
) {
    fun times(other: Int): Int {
        return value * other
    }
}
