package lotto.views

import lotto.domain.Lotto

class ResultView {

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println(it)
        }
    }
}
