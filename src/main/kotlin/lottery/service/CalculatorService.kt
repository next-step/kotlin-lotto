package lottery.service

import lottery.domain.ranking.Ranking
import lottery.domain.winningresult.WinningResult
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculatorService {
    fun rateOfReturn(amount: Long, result: WinningResult): String {
        val earning = Ranking.values().sumOf {
            result[it.rank]!!.times(it.prize)
        }

        return decimalFormat.format(earning.toDouble().div(amount.toDouble()))
    }

    companion object {
        private val decimalFormat = DecimalFormat("#.##").also {
            it.roundingMode = RoundingMode.DOWN
        }
    }
}