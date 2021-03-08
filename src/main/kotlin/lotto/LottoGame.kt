package lotto

import kotlin.math.truncate

class LottoGame(pickLottoNumbers: List<LottoNumber>, winningNumber: LottoNumber) {
    val result: Result =
        Result(pickLottoNumbers.map { Ranking(it, winningNumber).rank })

    class Result(private val ranks: List<Ranking.Rank>) : List<Ranking.Rank> by ranks {
        val entries: Map<Ranking.Rank, Int> = ranks.groupingBy { it }.eachCount()
        val income: Long = entries.map { (rank, count) -> rank.prize(count) }.sum()
        val profit: Double = (income / TicketAmount(entries.values.sum()) * 100).truncate

        private operator fun Long.div(ticketAmount: TicketAmount): Double = this / ticketAmount.amount.toDouble()
        private val Double.truncate: Double
            get() = truncate(this) / 100
    }
}
