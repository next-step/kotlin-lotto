package lotto.view

import lotto.application.common.Number
import lotto.application.common.NumberString
import lotto.application.common.NumberStringList
import lotto.domain.Payment

class InputView {

    fun inputPayment(): Payment {
        println(INPUT_PAYMENT_GUIDE)
        val payment = NumberString(readln())
        return Payment(payment.toNumber())
    }

    fun inputLuckyNumbers(): List<Number> {
        println(INPUT_LUCKY_NUMBERS_GUIDE)
        return NumberStringList(readln()).toNumberList()
    }

    fun inputBonusNumber(): Number {
        println(INPUT_BONUS_BALL)
        val bonusBallNumberString = readln()
        return Number(bonusBallNumberString.toInt())
    }

    private companion object {
        const val INPUT_PAYMENT_GUIDE = "# 구입금액을 입력해주세요."
        const val INPUT_LUCKY_NUMBERS_GUIDE = "# 지난 주 당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_BALL = "# 보너스 볼을 입력해 주세요."
    }
}
