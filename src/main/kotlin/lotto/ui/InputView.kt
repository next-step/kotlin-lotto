package lotto.ui

class InputView {
    fun inputPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLotto(count: Int): List<String> {
        if (count > 0) {
            println("수동으로 구매할 번호를 입력해 주세요.")
            return List(count) { readln() }
        }
        return emptyList()
    }

    fun inputLastWeekNumbers(): String {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
