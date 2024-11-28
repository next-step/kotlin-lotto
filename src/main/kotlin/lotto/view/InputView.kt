package lotto.view

object InputView {
    fun inputLottoAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        return readln().toInt()
    }
}
