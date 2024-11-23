package lotto.view.input

object BuyInputView {
    fun print(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }
}
