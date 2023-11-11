package lotto.presentation

import lotto.domain.Lotto

class OutputManager {
    fun printUserPay(pay: Int) {
        println(pay)
    }

    fun printSellLottoCount(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.getNumbers())
        }
    }
}