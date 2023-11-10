package lotto.view

import lotto.domain.Money

class InputView {

    fun inputMoney(): Money {
        println("구입금액을 입력해 주세요.")
        return Money(readln().toInt())
    }

    fun inputWinningLotto(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map { it.trim().toInt() }.toSet()
    }

    fun inputBonusBall(): Int {
        println("보너스 볼을 입력해 주세요..")
        return readln().toInt()
    }
}
