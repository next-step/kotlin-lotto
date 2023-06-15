package lotto.io

import lotto.domain.Lotto

object ResultView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개 구매했습니다")
    }
}
