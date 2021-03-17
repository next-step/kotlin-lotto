package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class Money(initMoney: Int) {
    var spentMoney: Long = 0L
        private set
    var currentMoney: Long = initMoney.toLong()
        private set

    init {
        checkValidateMoney(initMoney)
    }

    fun spendMoney(money: Int) {
        currentMoney -= money
        spentMoney += money
    }

    fun spendAllMoney() {
        spentMoney += currentMoney
        currentMoney -= currentMoney
    }

    fun calculateRateOfReturn(winningMoney: Long): String {
        return BigDecimal(winningMoney)
            .divide(spentMoney.toBigDecimal(), 2, RoundingMode.FLOOR)
            .toString()
    }

    private fun checkValidateMoney(money: Int) {
        require(money > 0) { "돈은 0보다 큰 수를 입력해주세요" }
    }
}
