package lotto.view

object InputView {
    fun getAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toIntOrNull() ?: throw IllegalArgumentException("Invalid input")
    }

    fun getWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map { it.trim().toInt() }.toSet()
    }
}
