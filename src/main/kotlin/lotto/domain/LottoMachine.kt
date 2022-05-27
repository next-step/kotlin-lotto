package lotto.domain

class LottoMachine(private val receipt: Receipt) {
    fun issue(): LottoTickets {
        val lottoTickets = List(receipt.lottoCount) { LottoTicket(LottoGenerator().generateNumbers()) }
        return LottoTickets(lottoTickets)
    }

    fun verify(lastNumber: LottoTicket, lottoTickets: LottoTickets): List<StatResult> {
        val checker = Checker(lastNumber)
        return MatchStates(lottoTickets.win(checker)).accumulate()
    }

    fun yields(resultList: List<StatResult>): Double {
        return StatResults(resultList).yield(receipt)
    }
}
