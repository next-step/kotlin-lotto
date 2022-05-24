package lotto.view

import lotto.Lotto

object LottoOutputView {
    fun printPurchaseLotto(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto.numbers)
        }
    }
}
