package lotto.view

object InputView {
    fun askPurchase(): Int {
        println("구입금액을 입력해주세요.")
        val input = readLine()
        require(!input.isNullOrBlank()) { "구입 금액은 양수인 숫자이어야 합니다." }
        return input.toInt()
    }

    fun askWinningNumbers(): List<Int> {
        println("지난주 당첨 번호를 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank()) { "당첨 번호는 , 로 구분된 6개의 숫자이어야 합니다." }
        return input.filterNot { it.isWhitespace() }
            .split(WINNING_NUMBER_DELIMITER).map { it.toInt() }
    }

    private const val WINNING_NUMBER_DELIMITER = ","
}
