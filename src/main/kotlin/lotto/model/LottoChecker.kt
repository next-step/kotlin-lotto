package lotto.model

class LottoChecker(winner: Lotto, myLottos: List<Lotto>) {
    private val lottos: List<Lotto> = checkEachLotto(winner, myLottos)

    fun getLottos(): List<Lotto> {
        return lottos
    }

    fun getEarningRate(): Double {
        val totalPrize = lottos.sumBy { it.checkPrize() }.toDouble()
        val paidMoney = lottos.size * LOTTO_PRICE.toDouble()

        return totalPrize / paidMoney
    }

    private fun checkEachLotto(winner: Lotto, lottos: List<Lotto>): List<Lotto> {
        lottos.forEach {
            it.checkWin(winner)
        }
        return lottos
    }
}
