package lotto.model

object OneToSixLottoTicketStorage : LottoTicketStorage {
    override val lottoTicket: LottoTicket = LottoTicket((LottoNumber(1)..LottoNumber(6)).toSet())
}