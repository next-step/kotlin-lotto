package lotto.domain

class ProfitRate(totalPrize: Amount, purchaseAmount: Amount) {

    val value = totalPrize.value.toDouble() / purchaseAmount.value.toDouble()
}
