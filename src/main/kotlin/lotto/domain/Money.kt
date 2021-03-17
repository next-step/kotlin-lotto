package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Money(initMoney: Int) {
    var spentMoney: Long = 0L
        private set
    var currentMoney: Long = initMoney.toLong()
        private set

    fun spendMoney(money: Int) {
        currentMoney -= money
        spentMoney += money
    }

    fun spendAllMoney() {
        spentMoney += currentMoney
        currentMoney -= currentMoney
    }

    fun calculateRateOfReturn(winningMoney: Long): String {
        return BigDecimal(winningMoney).divide(spentMoney.toBigDecimal(), 2, RoundingMode.FLOOR).toString()
    }
}
