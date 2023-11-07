package study.lotto.view

class InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
            ?.toIntOrNull()
            ?: 0
    }

    fun getLastWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull()
            ?.split(',')
            ?.mapNotNull { it.trim().toIntOrNull() }
            ?: emptyList()
    }
}
