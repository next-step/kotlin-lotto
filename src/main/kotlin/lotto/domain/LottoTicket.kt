package lotto.domain

data class LottoTicket(
    val numbers: List<Int>,
) {
    infix fun contains(number: Number): Boolean =
        numbers.contains(number)

    infix fun countMatched(other: LottoTicket) =
        numbers.count { other contains it }
}
