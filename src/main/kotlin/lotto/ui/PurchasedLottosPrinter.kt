package lotto.ui

import lotto.domain.Lotto

object PurchasedLottosPrinter {
    fun print(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { lotto -> println(lotto.lottoNumbers.map { it.number }) }
    }
}
