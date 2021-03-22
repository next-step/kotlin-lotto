package lotto.domain

class Money(initMoney: Int) {
    var spentMoney: Long = 0L
        private set
    var currentMoney: Long = initMoney.toLong()
        private set

    init {
        checkValidateMoney(initMoney)
    }

    fun getQuantityOfAvailablePurchase(): Int {
        val quantity = (currentMoney / LOTTO_COST).toInt()
        spentMoney += currentMoney
        currentMoney -= currentMoney
        return quantity
    }

    fun spendMoney(money: Int) {
        checkEnoughMoney(money)
        currentMoney -= money
        spentMoney += money
    }

    private fun checkEnoughMoney(spendMoney: Int) {
        check(spendMoney <= currentMoney) {
            "사고자 하는 수량이 현재 가진 돈보다 많습니다.[현재 돈 :$currentMoney 쓰려는 돈: $spendMoney]"
        }
    }

    private fun checkValidateMoney(money: Int) {
        require(money > 0) { "돈은 0보다 큰 수를 입력해주세요" }
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
