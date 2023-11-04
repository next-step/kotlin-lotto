package lotto.view

import lotto.domain.Lotto

object OutputView {
    fun outputLotto(purchaseCount: Int, lottos: List<Lotto>) {
        println("${purchaseCount}개를 구매했습니다.")

        lottos.forEach {
            println(it.numbers)
        }
        println()
    }
}
