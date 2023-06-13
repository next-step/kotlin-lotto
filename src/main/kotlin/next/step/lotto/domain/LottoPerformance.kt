package next.step.lotto.domain

object LottoPerformance {
    fun analyze(payment: Int, totalWinnings: Int): String = "%.2f".format(totalWinnings / payment.toDouble())
}