package lotto.view

object InputView {

    fun requestPrice(): Int {
        println("구입 금액을 입력해주세요.")
        return readLine()?.toInt() ?: 0
    }
}
