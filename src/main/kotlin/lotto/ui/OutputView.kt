package lotto.ui

import lotto.Lotto

class OutputView {
    fun printPurchasedQuantity(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun printPurchasedLottos(lottos: List<Lotto>) {
        for(lotto in lottos) {
            println(lotto.getLottoNumbers())
        }
    }
}
