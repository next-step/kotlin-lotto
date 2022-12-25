package lotto.ui

internal class InputView {
    fun inputPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLastWeekNumbers(): String {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun inputBonusNumber(): Int {
        println()
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
