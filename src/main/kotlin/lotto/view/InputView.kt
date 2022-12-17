package lotto.view

import lotto.domain.Payment

object InputView {
    fun readPayment(): Payment {
        println("구입금액을 입력해 주세요.")

        return Payment(readln().toInt())
    }

    fun readWinningNumber(): IntArray {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln().split(",")
            .map { Integer.parseInt(it.trim()) }
            .toIntArray()
    }

    fun readBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")

        return readln().toInt()
    }
}
