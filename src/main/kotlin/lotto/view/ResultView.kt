package lotto.view

import lotto.Lottos

object ResultView {
    fun printNumOfLottos(lottos: Lottos) {
        println("${lottos.size} 개를 구매했습니다.")
    }
}
