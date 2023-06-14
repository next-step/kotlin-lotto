package lotto.model

import kotlin.random.Random

object RandomLottoTicketStorage : LottoTicketStorage {

    private const val LOTTO_TICKET_SIZE: Int = LottoTicket.SIZE
    private val LOTTO_NUMBERS: Set<LottoNumber> = (LottoNumber.MIN..LottoNumber.MAX).toSet()

    override val lottoTicket: LottoTicket
        get() {
            return LOTTO_NUMBERS.shuffled(Random.Default)
                .take(LOTTO_TICKET_SIZE)
                .toSet()
                .let(::LottoTicket)
        }
}
