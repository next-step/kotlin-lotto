package lotto.domain

import lotto.domain.LottoGame.Companion.LOTTO_COST
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

    fun getQuantityOfAvailablePurchase(): Int {
        return (currentMoney / LOTTO_COST).toInt()
    }

    fun spendMoney(money: Int) {
        checkEnoughMoney(money)
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

    private fun checkEnoughMoney(spendMoney: Int) {
        if (spendMoney > currentMoney) throw IllegalStateException(
            "사고자 하는 수량이 현재 가진 돈보다 많습니다.[현재 돈 :$currentMoney 쓰려는 돈: $spendMoney]"
        )
    }

    private fun checkValidateMoney(money: Int) {
        require(money > 0) { "돈은 0보다 큰 수를 입력해주세요" }
    }
}
