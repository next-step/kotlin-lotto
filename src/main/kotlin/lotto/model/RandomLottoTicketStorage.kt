package lotto.model

import kotlin.random.Random

object RandomLottoTicketStorage : LottoTicketStorage {

    private const val LOTTO_TICKET_SIZE: Int = LottoTicket.SIZE
    private val LOTTO_NUMBERS: Set<LottoNumber> = LottoNumber.ALL

    override fun hasCountLessThan(count: Int): Boolean {
        return false
    }

    override fun lottoTicketsBy(count: Int): Collection<LottoTicket> {
        return (0 until count).map {
            LOTTO_NUMBERS.shuffled(Random.Default)
                .take(LOTTO_TICKET_SIZE)
                .toSet()
                .let { LottoTicket(Lotto(it), TicketType.AUTOMATIC) }
        }
    }
}
