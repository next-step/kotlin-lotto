package lotto.view

import lotto.model.WinningNumbers

object InputView {
    fun purchaseAmount(pricePerGame: Int): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseGameCount: Int = readln().toInt() / pricePerGame
        println("$purchaseGameCount 개를 구매했습니다.")
        return purchaseGameCount
    }

    fun drawing(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val s = readlnOrNull() ?: ""
        return WinningNumbers(s)
    }
}
