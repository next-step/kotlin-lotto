package lotto.view

class InputView {
    fun requestPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun requestWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(", ")
            .map { it.toInt() }
            .toList()
    }

    fun requestBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}