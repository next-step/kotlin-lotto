package lotto.domain

class Money(initMoney: Int) {
    var spentMoney: Long = 0
        private set
    var currentMoney: Long = initMoney.toLong()
        private set

    fun earnMoney(money: Long) {
        currentMoney += money
    }

    fun spendMoney(money: Int) {
        currentMoney -= money
        spentMoney += money
    }

    fun spendAllMoney() {
        currentMoney -= currentMoney
        spentMoney += currentMoney
    }

    fun calculateRateOfReturn(): String {
        return String.format("%.2f", currentMoney.toFloat() / spentMoney.toFloat())
    }
}
