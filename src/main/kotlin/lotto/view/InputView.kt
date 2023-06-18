package lotto.view

object InputView {

    val purchaseMoney: Long
        get() {
            println("구입금액을 입력해 주세요.")
            return readlnOrNull()?.toLong() ?: throw IllegalArgumentException("구입금액은 필수입니다.")
        }

    val manualLottoCount: Int
        get() {
            println()
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("수동 로또 수는 필수입니다.")
        }

    fun manualLottoNumbers(count: Int): List<List<Int>> {
        println()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (0 until count).map { numbers }
    }

    val winnerNumbers: List<Int>
        get() {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return numbers
        }

    private val numbers: List<Int>
        get() {
            return readlnOrNull()
                ?.split(NUMBER_DELIMITER)
                ?.map { it.trim().toInt() }
                ?: throw IllegalArgumentException("로또 번호들은 필수입니다.")
        }

    private const val NUMBER_DELIMITER = ","

    val bonusBall: Int
        get() {
            println("보너스 볼을 입력해 주세요.")
            return readlnOrNull()?.toInt() ?: throw IllegalArgumentException("보너스 볼은 필수입니다.")
        }
}
