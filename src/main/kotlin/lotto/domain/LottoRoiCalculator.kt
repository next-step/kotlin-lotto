package lotto.domain

object LottoRoiCalculator {

    fun calculateROI(totalIncome: Number, investMoney: Int): Double {
        return (totalIncome.toDouble() / investMoney)
    }

    fun calculateTotalIncome(findJackpotLotto: List<JackpotLevel>): Number {
        return findJackpotLotto.sumOf { it.price }
    }
}
