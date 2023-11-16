package lottery.domain

import lottery.view.InputView

class InputNumberGenerator : LottoNumberGenerator {

    override fun getNumbers(): List<Int> {
        return InputView.inputManualLottoNumbers()
    }
}
