package lotto.view

object InputView {
    fun readCash(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }

    fun readLastWeekMatchNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }
}
