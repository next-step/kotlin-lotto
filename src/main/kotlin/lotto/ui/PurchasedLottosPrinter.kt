package lotto.ui

import lotto.domain.Lotto

object PurchasedLottosPrinter {
    fun print(auto: List<Lotto>, manual: List<Lotto>) {
        println("수동으로 ${manual.size}장, 자동으로 ${auto.size}개를 구매했습니다.")
        manual.forEach { lotto -> println(lotto.lottoNumbers.map { it.number }) }
        auto.forEach { lotto -> println(lotto.lottoNumbers.map { it.number }) }
    }
}
