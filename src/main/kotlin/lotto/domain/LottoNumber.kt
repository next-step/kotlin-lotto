package lotto.domain

@JvmInline
value class LottoNumber(
    val value: List<Int>,
) {
    infix fun contains(number: Number): Boolean =
        value.contains(number)

    infix fun countMatched(other: LottoNumber) =
        value.count { other contains it }
}
