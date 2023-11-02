package lotto.view

import lotto.domain.Lottos

object OutputView {

    fun printLotto(lottos: Lottos) {
        println("로또 ${lottos.getLottoCount()}개를 구매했습니다.")
        lottos.lottos.forEach {
            println(it.numbers)
        }
    }
}
