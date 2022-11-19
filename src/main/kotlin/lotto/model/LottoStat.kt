package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

class LottoStat(private val lottoGrades: List<LottoGrade>, private val amount: Int) {
    val winningRate = winningRate()
    val gradeStat: Map<LottoGrade, Int> = gradeStat()

    private fun gradeStat() =
        lottoGrades.groupBy { it }
            .map { (key, value) -> key to value.size }
            .toMap()

    private fun winningRate(): BigDecimal {
        val sumLottoReward = lottoGrades.sumOf {
            it.reward
        }
        val calc = sumLottoReward.toDouble() / amount
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
