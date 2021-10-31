package lotto.domain

@JvmInline
value class LottoTicket private constructor(val numbers: List<Int>) {
    companion object {
        fun generateByAuto(): LottoTicket {
            return LottoTicket((1..50).shuffled().subList(0, 6))
        }
    }
}
