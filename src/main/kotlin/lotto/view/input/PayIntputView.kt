package lotto.view.input

object PayIntputView {
    fun print(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }
}
