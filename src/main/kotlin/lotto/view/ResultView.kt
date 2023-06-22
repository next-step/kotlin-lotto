package lotto.view

import lotto.domain.Lottos

class ResultView {
    companion object {
        fun printPurchaseLottoNum(lottos: Lottos) {
            println("${lottos.size}개를 구매했습니다.")
        }

        fun printLottos(lottos: Lottos) {
            lottos.lottos.forEach {
                println(it)
            }
        }
    }
}
