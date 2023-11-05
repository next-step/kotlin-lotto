package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money
import lotto.domain.WinningNumbers

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readln().toInt())
    }

    fun getWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val line = readln()
        return WinningNumbers(LottoNumbers(line.split(", ").map { LottoNumber(it.toInt()) }))
    }
}
