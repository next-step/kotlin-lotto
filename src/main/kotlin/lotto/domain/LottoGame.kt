package lotto.domain

class LottoGame(private var money: Money) {

    fun purchaseManualLottoes(numberOfManual: Int, stringManualNumbers: List<List<String>>): Lottoes {
        checkEnoughMoney(numberOfManual)
        money.spendMoney(LOTTO_COST * numberOfManual)
        val lottoStrategy = ManualStrategy(stringManualNumbers)

        return lottoStrategy.generateLotto(numberOfManual)
    }

    fun purchaseAutoLottoes(): Lottoes {
        val quantity = (money.currentMoney / LOTTO_COST).toInt()
        money.spendAllMoney()
        val lottoStrategy = AutoStrategy()

        return lottoStrategy.generateLotto(quantity)
    }

    private fun checkEnoughMoney(numberOfManual: Int) {
        if (numberOfManual * LOTTO_COST > money.currentMoney) throw IllegalStateException("사고자 하는 수량이 현재 가진 돈보다 많습니다.")
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
