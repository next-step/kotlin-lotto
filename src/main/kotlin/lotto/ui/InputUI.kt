package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money

object InputUI {

    fun receivePurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readln().toInt())
    }

    fun receiveWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().replace(" ", "").split(",").map(String::toInt).map(::LottoNumber)
        return LottoNumbers(numbers)
    }
}
