package lotto.domain

class Lottos(val tickets: List<LottoTicket>) {
    companion object {
        fun of(lottoNumbers: List<Set<LottoNumber>>): Lottos {
            val tickets = mutableListOf<LottoTicket>()
            for (lottoNumber in lottoNumbers) {
                tickets.add(LottoTicket(lottoNumber))
            }

            return Lottos(tickets)
        }
    }
}
