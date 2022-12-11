package lotto.view

object InputView {

    private const val DELIMITER = ","

    fun getPurchase(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: throw IllegalArgumentException("올바른 구입금액이 아닙니다.")
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine()?.split(DELIMITER)?.let { numbers ->
            numbers.map { number ->
                number.trim().toInt()
            }
        } ?: throw IllegalArgumentException("올바른 당첨 번호가 아닙니다.")
    }
}
