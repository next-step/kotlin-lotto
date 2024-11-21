package lotto.view

import lotto.domain.PurchasedLottos

class OutPutView {
    fun printLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printPurchasedLottos(purchasedLottos: PurchasedLottos) {
        purchasedLottos.lottos.forEach { println(it.numbers) }
        println()
    }
}
