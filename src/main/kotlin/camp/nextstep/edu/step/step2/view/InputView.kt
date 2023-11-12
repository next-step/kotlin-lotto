package camp.nextstep.edu.step.step2.view

import camp.nextstep.edu.step.step2.domain.amount.BuyAmount
import camp.nextstep.edu.step.step2.domain.lotto.Numbers

class InputView {

    fun getInputValueAndReturnBuyAmount(): BuyAmount {
        println("구입금액을 입력해 주세요.")
        return BuyAmount.of(readLine()!!.toLong())
    }

    fun inputLastWeekWinningNumbers(): Numbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Numbers.ofInputValues(numbers = readLine()!!)
    }

}
