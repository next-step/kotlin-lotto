package lotto.view

import lotto.domain.Payment

object InputView {
    fun readPayment(): Payment {
        println("구입금액을 입력해 주세요.")

        return Payment(readln().toInt())
    }

    fun readManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        return readln().toInt()
    }

    fun readManualLottos(count: Int): List<IntArray> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (1..count).map { readNumbers() }
    }

    fun readWinningNumber(): IntArray {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readNumbers()
    }

    private fun readNumbers() = readln().split(",")
        .map { Integer.parseInt(it.trim()) }
        .toIntArray()

    fun readBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")

        return readln().toInt()
    }
}
