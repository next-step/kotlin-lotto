package lotto.`in`

import lotto.domain.LottoMachine
import lotto.domain.vo.PurchaseAmount

class LottoController(private val input: ConsoleInput, private val outPut: ConsoleOutPut) {
    fun start() {
        val purchaseAmount = PurchaseAmount(input.getPurchaseAmount())
        val lottoNumbers = LottoMachine.createLottoNumbers(purchaseAmount)

        outPut.printPurchasedLottoCount(lottoNumbers.size)
        lottoNumbers.forEach { outPut.printLottoNumbers(it.numbers()) }
        val winnerNumbers = input.getWinnerNumbers()
    }
}
