package lotto.view

import lotto.domain.Lotto

object ResultView {

    fun printPurchasedLottos(lottos: List<Lotto>) {

        println("${lottos.size}개를 구매했습니다.")

        lottos.forEach {
            println(it.lottoNumbers.sorted())
        }
        println()
    }
}
