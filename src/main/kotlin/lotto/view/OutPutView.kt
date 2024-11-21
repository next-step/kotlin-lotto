package lotto.view

import lotto.Lotto

class OutPutView {
    fun printLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { println(it.numbers) }
        println()
    }
}
