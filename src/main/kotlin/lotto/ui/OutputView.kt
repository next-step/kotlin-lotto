package lotto.ui

import lotto.Lotto
import lotto.Lottos

class OutputView {
    fun printPurchasedQuantity(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun printPurchasedLottos(lottos: Lottos) {
        for(lotto in lottos.toList()) {
            println(lotto.getLottoNumbers())
        }
    }
}
