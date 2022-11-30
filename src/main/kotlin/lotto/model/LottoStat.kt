package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

private const val LOTTO_STAT_BASE_CORRECT_NUMBER = 3

class LottoStat(private val lottoGrades: List<LottoGrade>, private val purchaseAmount: PurchaseAmount) {
    val winningRate = winningRate()
    val gradeStat: Map<LottoGrade, Int> = gradeStat()

    private fun gradeStat() =
        LottoGrade.values()
            .filter { it.correctNumber >= LOTTO_STAT_BASE_CORRECT_NUMBER }
            .associateWith { lottoGrades.count { grade -> it === grade } }
            .toSortedMap(compareBy { it.reward })

    private fun winningRate(): BigDecimal {
        val sumLottoReward = lottoGrades.sumOf {
            it.reward
        }
        val calc = sumLottoReward.toDouble() / purchaseAmount.amount
        return BigDecimal(calc).setScale(2, RoundingMode.DOWN)
    }

    fun winningMessage(): String {
        val message: String? = when {
            winningRate < BigDecimal.ONE -> "손해"
            winningRate == BigDecimal.ONE -> "본전"
            winningRate > BigDecimal.ONE -> "이득"
            else -> null
        }
        return message ?: ""
    }
}
