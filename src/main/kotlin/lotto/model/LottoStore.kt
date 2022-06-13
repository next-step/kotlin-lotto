package lotto.model

class LottoStore {

    fun buy(money: Int): List<Lotto> {
        checkNegativeMoney(money)

        val lottoMachine = LottoMachine()
        return lottoMachine.createLottos(money / LOTTO_PRICE)
    }

    fun buy(remainMoney: Int, manualLottos: List<Lotto>): List<Lotto> {
        checkNegativeMoney(remainMoney)

        return manualLottos + buy(remainMoney)
    }

    private fun checkNegativeMoney(money: Int) {
        require(money >= ZERO_PRICE) { "금액이 음수가 될수는 없습니다." }
    }

    companion object {
        private const val ZERO_PRICE = 0
        private const val LOTTO_PRICE = 1000
    }
}
