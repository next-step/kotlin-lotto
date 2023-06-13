package lotto

import kotlin.random.Random

@JvmInline
value class RandomLottoTicketStorage(private val random: Random = Random.Default) : LottoTicketStorage {

    override val lottoTicket: LottoTicket
        get() {
            return LOTTO_NUMBERS.shuffled(random)
                .take(LOTTO_TICKET_SIZE)
                .toSet()
                .let(::LottoTicket)
        }

    companion object {
        private const val LOTTO_TICKET_SIZE: Int = LottoTicket.SIZE
        private val LOTTO_NUMBERS: Set<LottoNumber> = (LottoNumber.MIN..LottoNumber.MAX).toSet()
    }
}
