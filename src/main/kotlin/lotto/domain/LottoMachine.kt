package lotto.domain

class LottoMachine(private val receipt: Receipt) {
    fun issue(): LottoTickets {
        val lottoTickets = List(receipt.lottoCount) { LottoTicket(LottoGenerator().generateNumbers()) }
        return LottoTickets(lottoTickets)
    }

    fun verify(lastNumber: LottoTicket, lottoTickets: LottoTickets): StatResults {
        val checker = Checker(lastNumber)
        val matchStateList = lottoTickets.win(checker)
        val statResultList = MatchStates(matchStateList).accumulate()
        return StatResults(statResultList)
    }

    fun yields(results: StatResults): Double {
        return StatResults(results.statResults).yield(receipt)
    }
}
