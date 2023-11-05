package lotto.domain

class Bank(
    private var purchaseAmount: Amount = Amount(0),
    private var prizeAmount: Amount = Amount(0),
) {
    fun save(amount: Amount): Amount {
        purchaseAmount += amount
        return purchaseAmount
    }

    fun receivePrize(amount: Amount): Double {
        prizeAmount = amount
        return calculateEarningRate()
    }

    private fun calculateEarningRate(): Double {
        val earningRate = prizeAmount.value.toDouble() / purchaseAmount.value
        return (earningRate * 100).toInt() / 100.0
    }
}
