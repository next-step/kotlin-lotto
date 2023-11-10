package lotto.domain

@JvmInline
value class LottoCount(
    val value: Int,
) {
    fun multiply(other: Int): Int =
        value * other
}
