package lotto.view.input

import lotto.ErrorCode
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
        val numberList = runCatching {
            readln().split(DELIMITER).map { it.trim().toInt() }
        }.onFailure {
            throw IllegalArgumentException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER_INPUT_FORMAT.msg)
        }.getOrThrow()
        return numberList.map { SixFortyFiveNumber(it) }
    }

    private fun makePurchase(): SixFortyFiveLottoPurchase {
        val numbers = readValue()
        return SixFortyFiveLottoPurchase.ofManual(numbers)
    }

    companion object {
        const val DELIMITER = ","
    }
}
