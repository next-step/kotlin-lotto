package lotto.view

import lotto.controller.dto.LottoData

object ResultView {
    fun printPurchasedLottoNumber(lottoNumber: Int) {
        println("${lottoNumber}개를 구매했습니다.")
    }

    fun printLottos(lottoDatas: List<LottoData>) {
        lottoDatas.forEach { println(it.lottoNumbers) }
        println()
    }
}
