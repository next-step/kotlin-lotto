package lotto.view

import lotto.domain.Lotto

object OutputView {
    fun printNumberOfLottosBought(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { println(it.numbers) }
    }
}
