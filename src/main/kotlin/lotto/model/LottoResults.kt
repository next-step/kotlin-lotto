package lotto.model

class LottoResults(private val winningNumbers: List<LottoNumber>, private val bonusNumber: LottoNumber) {
    fun getResults(ticketNumbersList: List<List<LottoNumber>>): Map<Prize, Int> =
        ticketNumbersList.fold(mutableMapOf(), foldPrizeToMatchCountMap).toMap()

    private val foldPrizeToMatchCountMap = { results: MutableMap<Prize, Int>, ticketNumbers: List<LottoNumber> ->
        val matchCount = getMatchCount(ticketNumbers)
        val isBonus = matchCount == 5 && ticketNumbers.contains(bonusNumber)
        val key = Prize.getKeyWithMatched(matchCount, isBonus)
        results[key] = (results[key] ?: 0) + 1
        results
    }

    private fun getMatchCount(ticketNumbers: List<LottoNumber>): Int =
        ticketNumbers.intersect(winningNumbers.toSet()).size

    fun getProfit(results: Map<Prize, Int>): Double {
        val ticketCount = results.values.sum()
        val sumOfPrize = results.entries.fold(0) { sum, (key, value) ->
            sum + value * key.prize
        }
        return sumOfPrize.toDouble() / (LottoTicket.TICKET_PRICE * ticketCount).toDouble()
    }
}

