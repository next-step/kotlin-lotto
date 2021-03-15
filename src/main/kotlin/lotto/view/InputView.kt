package lotto.view

object InputView {
    tailrec fun purchase(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: purchase()
    }

    fun winNumber(): String {
        println("지난주 당첨 번호를 입력해주세요")
        return readLine() ?: ""
    }
}
