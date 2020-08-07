package lotto.view

import lotto.domain.WinningLotto
import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.Number

object InputView {

    fun inputMoney(): Money {
        println("금액을 입력해주세요")
        return Money(readLine())
    }

    fun inputCorrectLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Lotto(readLine()!!.split(","))
    }

    fun inputBonusBall(correctLotto: Lotto): WinningLotto {
        println("보너스 볼을 입력해 주세요.")
        return WinningLotto(correctLotto, Number(readLine()))
    }
}
