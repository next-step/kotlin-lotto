package lotto.ui.view

object InputView {
    fun getPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")

        return readLine()?.toIntOrNull() ?: 0
    }
}