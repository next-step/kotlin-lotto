package lotto

import kotlin.math.floor

class StatisticsRows(val rows: List<Statistics.Row> = emptyList())

class Statistics {
    var earnings = 0.0
        private set

    var statisticsRows = StatisticsRows()
        private set

    fun run(winningPrizes: WinningPrizes, purchaseMoney: PurchaseMoney) {
        statisticsRows = StatisticsRows(
            LottoResult.Prize.values().filter { it.price > 0 }
                .map {
                    Row(
                        standardPrize = it.price,
                        prize = it,
                        matchLottoCount = winningPrizes.prizes.filter { prize ->
                            prize == it
                        }.size,
                    )
                }.sortedBy {
                    it.prize.matchCount
                }
        )

        earnings = winningPrizes.prizes.sumOf { it.price }.let {
            println(it.toDouble() / purchaseMoney.money.toDouble())
            floor(it.toDouble() / purchaseMoney.money.toDouble() * 100) / 100
        }
    }

    data class Row(
        val standardPrize: Int,
        val prize: LottoResult.Prize,
        val matchLottoCount: Int
    )
}
