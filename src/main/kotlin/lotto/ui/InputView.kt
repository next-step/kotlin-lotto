package lotto.ui

object InputView {
    // 구입금액을 입력해주세요
    fun inputAmount(): Int {
        println(ENTER_LOTTO_PRICE)
        return readln().toIntOrNull() ?: error(ERROR_TEXT)
    }

    // 수동으로 구매할 로또 수를 입력해주세요
    fun inputManualCount(): Int {
        println()
        println(ENTER_MANUAL_LOTTO_COUNT)
        return readln().toIntOrNull() ?: error(ERROR_TEXT)
    }

    // 수동 구매 로또 입력
    fun inputManualLotto(): List<Int> {
        val input = readln()
        return transformLottoListFromInput(input)
    }

    // 구매한 총 로또 개수 계산
    fun calculateTotalLottoCount(input: Int): Int {
        val lottoCount = transformTotalLottoCountFromInput(input)
        check(lottoCount > MINIMUM_COUNT) { CHECK_MINIMUM_COUNT_TEXT }
        return lottoCount
    }

    // 입력된 금액으로 총 구매 가능 개수 계싼
    fun transformTotalLottoCountFromInput(input: Int): Int {
        return input / THOUSAND_WON
    }

    fun lastWeekInput(): List<Int> {
        println(ENTER_LAST_WEEK_LOTTO_NUMBER)
        val lastWeekLottoNumber = readln()
        return transformLottoListFromInput(lastWeekLottoNumber)
    }

    fun transformLottoListFromInput(lottoNumber: String): List<Int> {
        val lastWeekLottoNumberList = lottoNumber.replace(" ", "").split(DELIMITER)
        return kotlin.runCatching {
            lastWeekLottoNumberList.map { it.toInt() }.sorted()
        }.getOrNull() ?: error(ERROR_TEXT)
    }

    fun bonusBallInput(): Int {
        println(ENTER_THE_BONUS_NUMBER)
        val bonusBallNumber = readln()
        return kotlin.runCatching { bonusBallNumber.toInt() }.getOrNull() ?: error(ERROR_TEXT)
    }

    private const val ENTER_LOTTO_PRICE = "구입금액을 입력해 주세요."
    private const val ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val ERROR_TEXT = "올바른 숫자를 입력 해주세요"
    private const val MINIMUM_COUNT = 0
    private const val CHECK_MINIMUM_COUNT_TEXT = "1개 이상을 구매하세요"
    private const val THOUSAND_WON = 1000
    private const val ENTER_LAST_WEEK_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val ENTER_THE_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val DELIMITER = ','
}
