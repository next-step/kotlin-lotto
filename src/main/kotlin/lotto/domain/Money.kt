package lotto.domain

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
        return String.format("%.2f", winningMoney.toDouble() / spentMoney.toDouble())
    }
}
