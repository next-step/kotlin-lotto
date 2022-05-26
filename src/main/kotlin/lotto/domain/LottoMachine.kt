package lotto.domain

class LottoMachine(private val receipt: Receipt) {
    fun issue(): LottoTickets {
        val lottoTickets = List(receipt.lottoCount) { LottoTicket(LottoGenerator().generateNumbers()) }
        return LottoTickets(lottoTickets)
    }

    fun verify(lastNumber: LottoTicket, lottoTickets: LottoTickets): List<StatResult> {
        val checker = Checker(lastNumber)
        return Stat(lottoTickets, checker).sumRecords
    }

    fun yields(resultList: List<StatResult>): Double {
        val totalProfit = resultList.sumOf { it.sum }
        return Profit(
            profit = totalProfit.toDouble(),
            payment = receipt.payment.toDouble()
        ).yields
    }
}
