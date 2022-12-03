package lotto.`in`

import lotto.domain.vo.PurchaseAmount

class LottoController(private val input: ConsoleInput, private val outPut: ConsoleOutPut) {
    fun start() {
        val purchaseAmount = PurchaseAmount(input.getPurchaseAmount())
    }
}
