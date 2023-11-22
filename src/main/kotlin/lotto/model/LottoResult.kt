package lotto.model

class LottoResult(val results: Map<Prize, Int> ) {

    val profit
        get() = getLottoProfit()
    private fun getLottoProfit(): Double {
        val ticketCount = results.values.sum()
        val sumOfPrize = results.entries.fold(0) { sum, (key, value) ->
            sum + value * key.prize
        }
        return sumOfPrize.toDouble() / (LottoTicket.TICKET_PRICE * ticketCount).toDouble()
    }
}

