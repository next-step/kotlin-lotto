package lotto.view

import lotto.common.IntegerNumber
import lotto.common.NumberString
import lotto.common.NumberStringList
import lotto.domain.Payment

class InputView {

    fun inputPayment(): Payment {
        println(INPUT_PAYMENT_GUIDE)
        val payment = NumberString(readln())
        return Payment(payment.toIntegerNumber())
    }

    fun inputLuckyNumbers(): List<IntegerNumber> {
        println(INPUT_LUCKY_NUMBERS_GUIDE)
        return NumberStringList(readln()).toIntegerNumberList()
    }

    fun inputBonusNumber(): IntegerNumber {
        println(INPUT_BONUS_BALL)
        return NumberString(readln()).toIntegerNumber()
    }

    private companion object {
        const val INPUT_PAYMENT_GUIDE = "# 구입금액을 입력해주세요."
        const val INPUT_LUCKY_NUMBERS_GUIDE = "# 지난 주 당첨 번호를 입력해 주세요."
        const val INPUT_BONUS_BALL = "# 보너스 볼을 입력해 주세요."
    }
}
