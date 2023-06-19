package lotto

import lotto.view.input.sixFortyFiveNumberLotto.SixFortyFiveLottoChoiceInputView

fun main() {
    when (SixFortyFiveLottoChoiceInputView().value) {
        1 -> SixFortyFiveLottoController().startNormalLotto()
        2 -> SixFortyFiveLottoController().startBonusLotto()
    }
}
