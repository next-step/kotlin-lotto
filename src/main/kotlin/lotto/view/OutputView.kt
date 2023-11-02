package lotto.view

import lotto.domain.Lotto

object OutputView {

    fun printLotto(lottos: List<Lotto>) {
        println("로또 ${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }
}
