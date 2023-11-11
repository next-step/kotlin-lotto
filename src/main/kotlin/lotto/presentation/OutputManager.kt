package lotto.presentation

import lotto.domain.Lotto

class OutputManager {

    fun printSellLottoCount(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.getNumbers())
        }
        println()
    }
}