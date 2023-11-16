package specific.lotto.view

object InputView {
    fun getMoney(): String? {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
    }

    fun getWinningNumber(): String? {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull()
    }

}
