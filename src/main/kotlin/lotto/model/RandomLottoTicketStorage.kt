package lotto.model

import kotlin.random.Random

object RandomLottoTicketStorage : LottoTicketStorage {

    private const val LOTTO_SIZE: Int = Lotto.SIZE
    private val LOTTO_NUMBERS: Set<LottoNumber> = LottoNumber.ALL

    override infix fun hasCountLessThan(count: Int): Boolean {
        return false
    }

    override infix fun lottoTicketsBy(count: Int): Collection<LottoTicket> {
        return (0 until count).map {
            LOTTO_NUMBERS.shuffled(Random.Default)
                .take(LOTTO_SIZE)
                .toSet()
                .let { LottoTicket(Lotto(it), TicketType.AUTOMATIC) }
        }
    }
}
