package lotto.model

class LottoResults(val results: Map<Prize, Int> ) {

    val profit
        get() = getProfit()
    private fun getProfit(): Double {
        val ticketCount = results.values.sum()
        val sumOfPrize = results.entries.fold(0) { sum, (key, value) ->
            sum + value * key.prize
        }
        return sumOfPrize.toDouble() / (LottoTicket.TICKET_PRICE * ticketCount).toDouble()
    }
}

