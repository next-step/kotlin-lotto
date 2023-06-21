package lotto.view

import lotto.domain.WinningNumbers

class InputView {

    fun inputPurchasePrice(): Int {
        println("구입 금액을 입력해주세요.")
        return readln().toInt()
    }

    fun inputLastWinNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해주세요.")
        val inputData = readln().split(",").map { it.toInt() }
        return WinningNumbers(inputData)
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return readln().toInt()
    }
}
