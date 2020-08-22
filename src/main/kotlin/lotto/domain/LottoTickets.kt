package lotto.domain


class LottoTickets(val lottoTickets: List<LottoTicket>) {

    companion object{
        fun from(lottoTickets: List<LottoTicket>): LottoTickets {
            return LottoTickets(lottoTickets)
        }
    }
}
