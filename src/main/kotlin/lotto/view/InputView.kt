package lotto.view

class InputView {

    fun inputPurchasePrice(): Int {
        println("구입 금액을 입력해주세요.")
        return readln().toInt()
    }

    fun inputLastWinNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return readln().split(",").map { it.toInt() }
    }
}
