package lotto.model

import lotto.collection.LottoResults
import lotto.collection.LottoTicket
import lotto.collection.WinningMoney
import java.text.DecimalFormat


class ProfitCalculator {
    companion object {
        fun calculate(lottoResults: LottoResults): Double {
            val ticketCount = lottoResults.results.values.sum()

            val sumOfPrize = lottoResults.results.entries.fold(0) { sum, (key, value) ->
                sum + value * WinningMoney.getPrizePerMatch(key.toInt())
            }

            return DecimalFormat("#.##").format(sumOfPrize.toDouble() / (LottoTicket.TICKET_PRICE * ticketCount).toDouble()).toDouble()
        }
    }
}
