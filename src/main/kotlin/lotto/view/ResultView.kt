package lotto.view

import lotto.domain.Lotto

object ResultView {

    fun showPurchaseCount(purchaseCount: Int) {
        println("$purchaseCount 개를 구입하였습니다.")
    }

    fun showPurchasedLottos(lottos: List<Lotto>) {
        lottos.map { println(it.numbers) }
    }
}
