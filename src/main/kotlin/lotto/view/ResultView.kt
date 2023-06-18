package lotto.view

import lotto.Lottos

object ResultView {
    fun printPurchasedLottos(lottos: Lottos) {
        println("${lottos.size} 개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }
}
