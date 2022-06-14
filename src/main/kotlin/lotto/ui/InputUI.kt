package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money

object InputUI {

    fun receivePurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readln().toInt())
    }

    fun receiveManualPurchaseCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun receiveManualNumbers(): LottoNumbers {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return receiveNumbers()
    }

    fun receiveWinningNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return receiveNumbers()
    }

    fun receiveBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toInt())
    }

    private fun receiveNumbers(): LottoNumbers {
        val numbers = readln().replace(" ", "").split(",").map(String::toInt).map(::LottoNumber)
        return LottoNumbers(numbers)
    }
}
