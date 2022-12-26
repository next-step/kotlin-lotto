package lotto.domain

class LottoROIAnalysis {

    fun returnOnInvestment(winningPrize: Int, purchaseAmount: Int): Double =
        winningPrize.toDouble() / purchaseAmount
}
