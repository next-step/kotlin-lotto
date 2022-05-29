package lotto

object ResultView {
    fun printTickets(lottoTickets: LottoTickets) {
        println("${lottoTickets.lottery.size}개를 구매했습니다.")

        lottoTickets.lottery.forEach { lottoTicket ->
            println(lottoTicket.numbers.map { it.number })
        }
    }

    fun printStatistics(statisticsRows: StatisticsRows) {
        println("당첨 통계")
        statisticsRows.rows.forEach {
            val bonusText = if (it.prize == LottoResult.Prize.FIFTH_BONUS) {
                ", 보너스 볼 일치"
            } else {
                ""
            }

            println("${it.prize.matchCount}개 일치$bonusText ${it.standardPrize}원 (${it.matchLottoCount})개")
        }
    }

    fun printEarnings(earnings: Double) {
        println("총 수익률은 ${earnings}입니다")
    }
}
