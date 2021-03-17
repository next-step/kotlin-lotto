package lotto.domain

class LottoGame(private var money: Money) {

    fun purchaseLottoes(lottoStrategy: LottoStrategy, numberOfManual: Int = 0): Lottoes {
        if (numberOfManual > 0) {
            return purchaseManualLottoes(lottoStrategy, numberOfManual)
        }
        return purchaseAutoLottoes(lottoStrategy)
    }

    private fun purchaseManualLottoes(lottoStrategy: LottoStrategy, numberOfManual: Int): Lottoes {
        checkEnoughMoney(numberOfManual)
        money.spendMoney(LOTTO_COST * numberOfManual)

        return lottoStrategy.generateLotto(numberOfManual)
    }

    private fun purchaseAutoLottoes(lottoStrategy: LottoStrategy): Lottoes {
        val quantity = (money.currentMoney / LOTTO_COST).toInt()
        money.spendAllMoney()

        return lottoStrategy.generateLotto(quantity)
    }

    private fun checkEnoughMoney(numberOfManual: Int) {
        if (numberOfManual * LOTTO_COST > money.currentMoney) throw IllegalStateException("사고자 하는 수량이 현재 가진 돈보다 많습니다.")
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
