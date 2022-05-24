package lotto

class ResultView(
    private val writer: (String) -> Unit
) {

    fun printLottoTickets(tickets: List<LottoTicket>) {
        writeLine("${tickets.size}개를 구매했습니다.")
        tickets.forEach { ticket ->
            writer(ticket.numbers.joinToString(prefix = PREFIX_LOTTO_NUMBERS, postfix = POSTFIX_LOTTO_NUMBERS))
        }
    }

    fun printLottoStatistics(statistics: LottoStatistics) {
        printStatisticsHeader()
        printStatisticsMatch(statistics)
    }

    private fun printStatisticsHeader() {
        writeLine("당첨 동계")
        writeLine("-".repeat(10))
    }

    private fun printStatisticsMatch(statistics: LottoStatistics) {
        LottoMatch.values().forEach {
            writeLine("${it.count}개 일치 (${it.reward}원)- ${statistics.getMatchCount(it)}개")
        }
    }

    fun printStatisticsProfit(statistics: LottoStatistics, purchase: Int) {
        val profit = String.format("%.02f", statistics.getProfit(purchase))
        writeLine("총 수익률은 ${profit}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun writeLine(message: String) = writer("$message\n")

    companion object {
        private const val PREFIX_LOTTO_NUMBERS = "["
        private const val POSTFIX_LOTTO_NUMBERS = "]\n"
    }
}
