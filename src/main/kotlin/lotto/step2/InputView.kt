package lotto.step2

object InputView {
    fun getPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        val money = readln().toLong()
        return money
    }

    fun getLastWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map { it.trim().toInt() }
    }
}
