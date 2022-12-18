package lotto.view

object LotteryMachineInputView {

    fun inputPayAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
    }

    fun inputLastWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readLine().orEmpty()
            .split(",")
            .map { it.toIntOrNull() ?: throw IllegalArgumentException() }
    }
}
