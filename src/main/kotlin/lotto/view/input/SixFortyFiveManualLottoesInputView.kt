package lotto.view.input.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoCount
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchase
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoPurchases
import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import lotto.view.output.NewLineOutputView

class SixFortyFiveManualLottoesInputView(count: SixFortyFiveLottoCount) :
    InputView<List<SixFortyFiveNumber>, SixFortyFiveLottoPurchases>() {

    override val message: String = "수동으로 구매할 번호를 입력해주세요."
    override val value: SixFortyFiveLottoPurchases

    init {
        renderMessage()
        value = SixFortyFiveLottoPurchases((1..count.value).map { makePurchase() })
        NewLineOutputView()
    }

    override fun readValue(): List<SixFortyFiveNumber> {
        return readln().split(DELIMITER).map { SixFortyFiveNumber(it.trim().toInt()) }
    }

    private fun makePurchase(): SixFortyFiveLottoPurchase {
        val numbers = readValue()
        return SixFortyFiveLottoPurchase.ofManual(numbers)
    }

    companion object {
        const val DELIMITER = ","
    }
}
