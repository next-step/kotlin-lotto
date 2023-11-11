package lotto.view

import lotto.domain.Lotto

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println("[${lotto.lottoNumbers.joinToString(separator = ", ")}]")
    }
}
