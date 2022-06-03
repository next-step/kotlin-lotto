package lotto

class LottoStore {

    fun buy(money: Int): List<Lotto> {
        require(money >= ZERO_PRICE) { "금액이 음수가 될수는 없습니다." }

        val lottoMachine = LottoMachine()
        return lottoMachine.createLotto(money / LOTTO_PRICE)
    }

    companion object {
        private const val ZERO_PRICE = 0
        private const val LOTTO_PRICE = 1000
    }
}
