package lotto

import lotto.view.InputView

object LottoStore {
    fun open() {
        val totalPayment: Int = InputView.readTotalPayment()
    }
}

fun main() {
    LottoStore.open()
}
