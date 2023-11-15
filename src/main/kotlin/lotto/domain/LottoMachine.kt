
package lotto.domain

import lotto.view.InputView
import lotto.view.MessageView
import lotto.view.OutputView
import lotto.view.enum.Message

class LottoMachine(private var amount: Int = 0) {

    private final val inputView: InputView = InputView()
    private final val outputView: OutputView = OutputView()
    private final val messageView: MessageView = MessageView()

    fun buyLottoList(): List<Lotto> {
        val lottoCount: Int = this.amount / Lotto.LOTTO_PRICE

        return (0 until lottoCount).map { buyLotto(this.getLottoNumberList()) }
    }

    fun buyLotto(lottoNumberList: List<Int>): Lotto {
        processPayment(1)

        return Lotto(lottoNumberList)
    }

    fun buyManualLottoList(buyCount: Int): List<Lotto> {
        require(this.amount - (buyCount * Lotto.LOTTO_PRICE) >= 0) { this.messageView.getMessage(Message.LOTTO_PURCHASE_ERROR) }

        outputView.nextLinePrint(Message.QUESTION_MANUAL_LOTTO_NUMBER)
        val manualLottoList: MutableList<Lotto> = mutableListOf()
        repeat(buyCount) {
            manualLottoList.add(this.buyLotto(inputView.readLineNumberList()))
        }

        return manualLottoList
    }

    private fun processPayment(lottoCount: Int) {
        val paymentAmount: Int = (lottoCount * Lotto.LOTTO_PRICE)
        val remainingAmount: Int = this.amount - paymentAmount

        require(remainingAmount >= 0) { this.messageView.getMessage(Message.LOTTO_PURCHASE_ERROR) }
        this.amount = remainingAmount
    }

    private fun getLottoNumberList(): List<Int> {
        val lottoAreaList: List<Int> = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()

        return lottoAreaList.shuffled().subList(Lotto.NUMBER_COUNT_MIN, Lotto.NUMBER_COUNT_MAX)
    }
}
