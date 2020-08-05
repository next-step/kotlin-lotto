package lotto.view

import lotto.domain.BonusBall
import lotto.domain.Lotto
import lotto.domain.Number

object InputView {

    fun inputMoney(): Int {
        println("금액을 입력해주세요")
        return readLine()!!.toInt()
    }

    fun inputCorrectLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Lotto(readLine()!!.split(","))
    }

    fun inputBonusBall(correctLotto: Lotto): BonusBall {
        println("보너스 볼을 입력해 주세요.")
        return BonusBall(correctLotto, Number(readLine()))
    }
}
