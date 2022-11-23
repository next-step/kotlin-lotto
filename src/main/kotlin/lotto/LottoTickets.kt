package lotto

class LottoTickets private constructor(
    val tickets: List<LottoTicket>
) {
    companion object {

        fun randomTickets(count: Int): LottoTickets {
            require(count > 0) { "$count 는 양수만 올 수 있어요." }

            return LottoTickets(
                (0 until count).map { LottoTicket.randomTicket() }
            )
        }
    }
}
