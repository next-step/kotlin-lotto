package lotto

object ResultView {

    fun printTicketCount(lottoTicketCount: Int) {
        println("${lottoTicketCount}개를 구매했습니다.")
    }

    fun printTickets(lottoTickets: LottoTickets) {
        lottoTickets.lottery.forEach {
            println(it.numbers)
        }
    }

    fun printStatistics(statisticsRows: StatisticsRows) {
        println("당첨 통계")
        statisticsRows.rows.forEach {
            println("${it.prize.machCount}개 일치 ${it.standardPrize}원 (${it.machLottoCount})개")
        }
    }

    fun printEarnings(earnings: Double) {
        println("총 수익률은 ${earnings}입니다")
    }
}
