package lotto.view

import lotto.common.IntegerNumberList
import lotto.common.NumberString
import lotto.common.NumberStringList
import lotto.domain.Payment

class InputView {

    fun inputPayment(): Payment {
        println(INPUT_PAYMENT_GUIDE)
        val payment = NumberString(readln())
        return Payment(payment.toIntegerNumber())
    }

    fun inputManualLottoCount(): Int {
        println(INPUT_MANUAL_LOTTO_COUNT_GUIDE)
        return inputNumber()
    }

    fun inputManualLottoNumbers(count: Int): List<IntegerNumberList> {
        println(INPUT_MANUAL_LOTTO_NUMBERS_GUIDE)
        return List(count) {
            inputNumberList()
        }
    }

    fun inputLuckyNumbers(): IntegerNumberList {
        println(INPUT_LUCKY_NUMBERS_GUIDE)
        return inputNumberList()
    }

    private fun inputNumberList(): IntegerNumberList {
        val numberList = NumberStringList(readln()).toIntegerNumberList()
        return IntegerNumberList(numberList)
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_BALL)
        return inputNumber()
    }

    private fun inputNumber(): Int {
        return NumberString(readln()).toIntegerNumber()
    }

    private companion object {
        const val INPUT_PAYMENT_GUIDE = "# 구입금액을 입력해주세요."
        const val INPUT_MANUAL_LOTTO_COUNT_GUIDE = "# 수동으로 구매할 로또 수를 입력해 주세요."
        const val INPUT_MANUAL_LOTTO_NUMBERS_GUIDE = "# 수동으로 구매할 번호를 입력해 주세요."
        const val INPUT_LUCKY_NUMBERS_GUIDE = "# 지난 주 당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_BALL = "# 보너스 볼을 입력해 주세요."
    }
}
