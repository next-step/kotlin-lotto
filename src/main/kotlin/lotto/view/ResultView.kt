package lotto.view

import lotto.model.Lotto

object ResultView {
    fun printLottoCount(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
    }
}
