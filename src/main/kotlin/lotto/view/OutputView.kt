package lotto.view

import lotto.domain.Lotto

class OutputView {
    fun printPurchaseResult(purchasedLottos: List<Lotto>) {
        println("${purchasedLottos.size} $PURCHASE_RESULT_MESSAGE")
        printLottoNumbers(purchasedLottos)
    }

    private fun printLottoNumbers(purchasedLottos: List<Lotto>) {
        purchasedLottos.forEach {
            println(it)
        }
    }

    companion object {
        private const val PURCHASE_RESULT_MESSAGE = "개를 구매했습니다."
    }
}
