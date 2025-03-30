package lotto.view

import lotto.Lotto

class ResultView {
    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers.toString())
    }
}
