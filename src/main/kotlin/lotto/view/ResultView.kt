package lotto.view

import lotto.model.Lotto

object ResultView {

    fun printPurchasedLottoNumbers(purchasedLotto: List<Lotto>) {
        println("${purchasedLotto.size}개를 구매했습니다.")
        purchasedLotto.map { println(it.numbers) }
        println()
    }
}
