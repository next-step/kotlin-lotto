package lotto.model

class LottoResults(private val winningNumbers: List<LottoNumber>, private val bonusNumber: LottoNumber) {
    fun getResult(ticketNumbersList: List<List<LottoNumber>>) =
        ticketNumbersList.fold(mutableMapOf(), foldPrizeToMatchCountMap).toMap()

    private val foldPrizeToMatchCountMap = { results: MutableMap<Prize, Int>, ticketNumbers: List<LottoNumber> ->
        val matchCount = getMatchCount(ticketNumbers)
        val key = Prize.getKeyWithMatched(matchCount, ticketNumbers.contains(bonusNumber))
        results[key] = (results[key] ?: 0) + 1
        results
    }

    private fun getMatchCount(ticketNumbers: List<LottoNumber>): Int =
        ticketNumbers.intersect(listOf(*winningNumbers.toTypedArray(), bonusNumber).toSet()).size

    fun getProfit(results: Map<Prize, Int>): Double {
        val ticketCount = results.values.sum()
        val sumOfPrize = results.entries.fold(0) { sum, (key, value) ->
            sum + value * key.prize
        }
        return sumOfPrize.toDouble() / (LottoTicket.TICKET_PRICE * ticketCount).toDouble()
    }
}

