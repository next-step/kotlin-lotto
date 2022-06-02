package lotto.view

import calculator.StringParser
import calculator.parseToInt
import lotto.LottoNumber
import lotto.ManualPurchaseNumbers

object LottoInputView {

    fun purchaseInputView(): Int {
        println("구입 금액을 입력해 주세요")
        return parseToInt(readln())
    }

    fun manualPurchaseCountInputView(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요")
        return parseToInt(readln())
    }

    fun manualLottoNumberInputView(manualPurchaseCount: Int): ManualPurchaseNumbers {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val bunchOfNumbers = List(manualPurchaseCount) {
            StringParser.getNumberStrings(readln())
                .map(::parseToInt)
                .map(::LottoNumber)
        }
        return ManualPurchaseNumbers(bunchOfNumbers)
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
