package lotto.view

private const val MONEY_STRING = "구입금액을 입력해 주세요."

private const val LAST_NUM_STRING = "\n지난 주 당첨 번호를 입력해 주세요."

object InputView {
    fun getMoney(): Int {
        println(MONEY_STRING)
        return readln().toInt()
    }

    fun getLastLottoNums(): List<Int> {
        println(LAST_NUM_STRING)
        return readln().split(",").map { it.trim().toInt() }
    }
}
