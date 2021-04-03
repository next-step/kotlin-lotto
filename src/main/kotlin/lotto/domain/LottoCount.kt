package lotto.domain

data class LottoCount(private val count: Int) {
    constructor(count: String) : this(count.toInt())

    operator fun minus(other: LottoCount) = LottoCount(count - other.count)

    fun repeat(action: (Int) -> LottoTicket) = (1..count).map(action)
}
