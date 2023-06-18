package lotto.view

private const val MONEY_STRING = "구입금액을 입력해 주세요."

object InputView {
    fun getMoney(): Int {
        println(MONEY_STRING)
        return readln().toInt()
    }
}