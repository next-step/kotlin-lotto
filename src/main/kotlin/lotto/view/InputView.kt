package lotto.view

import lotto.domain.Payment
import lotto.domain.WinningNumber

object InputView {
    fun readPayment(): Payment {
        println("구입금액을 입력해 주세요.")

        return Payment(readln().toInt())
    }

    fun readWinningNumber(): WinningNumber {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val numbers = readln().split(",")
            .map { Integer.parseInt(it.trim()) }
            .toIntArray()

        println("보너스 볼을 입력해 주세요.")

        val bonusBall = readln().toInt()

        return WinningNumber(*numbers, bonusBall = bonusBall)
    }
}
