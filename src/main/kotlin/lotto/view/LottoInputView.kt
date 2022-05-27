package lotto.view

import calculator.StringParser
import calculator.parseToInt

object LottoInputView {

    fun purchaseInputView(): Int {
        println("구입 금액을 입력해 주세요")
        return parseToInt(readln())
    }

    fun lastWinnerLotteryInputView(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주십시오.")
        return StringParser.getNumberStrings(readln()).map(::parseToInt)
    }

    fun bonusNumberInputView(): Int {
        println("보너스 볼을 입력해 주세요.")
        return parseToInt(readln())
    }
}
