package lotto

import lotto.LottoPrice.Companion.LOTTO_PRICE

class Lottos(private val money: Int) {

    private var purchasedLottos = mutableListOf<Lotto>()

    fun buy(): List<Lotto> {
        purchasedLottos = MutableList(money / LOTTO_PRICE) { Lotto() }
        return purchasedLottos.toList()
    }

    fun correspondToWinningNumber(winningNumber: List<Int>): List<LottoResult> =
        LottoResults(purchasedLottos).result(winningNumber)
}
