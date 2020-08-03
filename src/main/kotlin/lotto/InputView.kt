package lotto

object InputView {
    fun getAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readLine()!!
    }

    fun getPrizedNumbers(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!
    }
}
