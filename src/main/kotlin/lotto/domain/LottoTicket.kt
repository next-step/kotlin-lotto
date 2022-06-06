package lotto.domain

class LottoTicket(val lottoNums: List<LottoNum>) {
    operator fun plus(lottoTicket: LottoTicket): LottoTicket {
        val result = ArrayList<LottoNum>(this.lottoNums.size + lottoTicket.lottoNums.size)
        result.addAll(this.lottoNums)
        result.addAll(lottoTicket.lottoNums)

        return LottoTicket(result)
    }

    companion object {
        const val TICKET_PRICE = 1_000
    }
}
