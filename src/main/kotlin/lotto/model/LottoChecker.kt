package lotto.model

import lotto.model.Money.Companion.calculateRate

class LottoChecker(winner: WinnerLotto, myLottos: List<Lotto>) {
    private val lottos: List<Lotto> = checkEachLotto(winner, myLottos)

    fun getLottos(): List<Lotto> {
        return lottos
    }

    fun getEarningRate(): Double {
        return calculateRate(lottos.map { it.win.prize })
    }

    private fun checkEachLotto(winner: WinnerLotto, lottos: List<Lotto>): List<Lotto> {
        lottos.forEach {
            it.checkWin(winner)
        }
        return lottos
    }
}
