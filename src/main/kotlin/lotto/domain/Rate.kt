package lotto.domain

class Rate(private val winAmount: Amount, private val amount: Amount) {

    fun toReturn(): Double {
        return winAmount.divide(amount) * 100
    }
}