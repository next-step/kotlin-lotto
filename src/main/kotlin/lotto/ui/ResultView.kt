package lotto.ui

import lotto.domain.Lotto

class ResultView {

    companion object {

        fun printPurchaseLotto(lottos: List<Lotto>) {
            println("${lottos.size}개를 구매했습니다")
            println(lottos.joinToString { "\n" })
        }
    }
}