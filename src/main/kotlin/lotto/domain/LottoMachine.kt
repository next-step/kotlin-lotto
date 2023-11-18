
package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.enum.Message

class LottoMachine(private var amount: LottoAmount = LottoAmount(0)) {

    private final val inputView: InputView = InputView()
    private final val outputView: OutputView = OutputView()

    fun buyLottoList(): List<Lotto> {
        val lottoCount: Int = amount.getLottoCount()

        return (0 until lottoCount).map { buyLotto(this.getLottoNumberList()) }
    }

    fun buyLotto(lottoNumberList: List<Int>): Lotto {
        amount.processPayment(1)

        return Lotto(lottoNumberList)
    }

    fun buyManualLottoList(buyCount: Int): List<Lotto> {
        amount.processPayment(buyCount)

        outputView.nextLinePrint(Message.QUESTION_MANUAL_LOTTO_NUMBER)
        val manualLottoList: MutableList<Lotto> = mutableListOf()
        repeat(buyCount) {
            manualLottoList.add(Lotto(inputView.readLineNumberList()))
        }

        return manualLottoList
    }

    private fun getLottoNumberList(): List<Int> {
        val lottoAreaList: List<Int> = (Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX).toList()

        return lottoAreaList.shuffled().subList(Lotto.NUMBER_COUNT_MIN, Lotto.NUMBER_COUNT_MAX)
    }
}
