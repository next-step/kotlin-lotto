package lotto.view

import lotto.ball.BonusBall

object InputView {
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력하세요.")
        return readlnOrNull()?.toInt() ?: 0
    }

    fun inputLastWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return (readlnOrNull() ?: "").split(",").map { it.trim().toInt() }
    }

    fun inputBonusBall(): BonusBall {
        println("보너스 볼을 입력해주세요.")
        return BonusBall(readlnOrNull()?.toInt() ?: 0)
    }
}
