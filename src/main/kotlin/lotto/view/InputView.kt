package lotto.view

object InputView {

    fun getPrincipal(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getLottoAnswer(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(", ").map { it.toInt() }
    }
}