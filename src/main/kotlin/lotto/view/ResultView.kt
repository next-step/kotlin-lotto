package lotto.view

import lotto.domain.Lotto

class ResultView {
    fun printPurchaseAmount(amount: Int) {
        println("$amount 개를 구매했습니다.")
    }

    fun printLotto(lotto: Lotto) {
        println("[${lotto.numbers.joinToString(", ")}]")
    }
}
