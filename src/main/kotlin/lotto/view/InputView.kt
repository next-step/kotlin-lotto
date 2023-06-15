package lotto.view

object InputView {

    val purchaseMoney: Long
        get() {
            println("구입금액을 입력해 주세요.")
            return readlnOrNull()?.toLong() ?: throw IllegalArgumentException("구입금액은 필수입니다.")
        }

    val winnerNumbers: List<Int>
        get() {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return readlnOrNull()
                ?.split(WINNER_NUMBER_DELIMITER)
                ?.map { it.trim().toInt() }
                ?: throw IllegalArgumentException("지난 주 당첨 번호는 필수입니다.")
        }
    private const val WINNER_NUMBER_DELIMITER = ","

    val bonusBall: Int
        get() {
            println("보너스 볼을 입력해 주세요.")
            return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("보너스 볼은 필수입니다.")
        }
}
