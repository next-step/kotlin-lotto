package lotto.view

object InputView {
    fun inputLottoAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningLotto(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.\n\t예) 1, 2, 3, 4, 5, 6")
        return readln()
    }
}
