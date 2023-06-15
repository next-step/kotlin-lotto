package lotto.view

import lotto.domain.WinningLotto

class InputView {
    fun inputPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLastWeekLottoNumbers(): WinningLotto {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(", ").map { it.toInt() }
        return WinningLotto(numbers)
    }
}
