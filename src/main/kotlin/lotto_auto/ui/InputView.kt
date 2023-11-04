package lotto_auto.ui

object InputView {
    fun input(): Int {
        println(ENTER_LOTTO_PRICE)

        return readln().toIntOrNull() ?: error(ERROR_TEXT)
    }

    fun lottoCount(input: Int): Int {
        val lottoCount = transformLottoCountFromInput(input)
        check(lottoCount > MINIMUM_COUNT) { CHECK_MINIMUM_COUNT_TEXT }

        println("${lottoCount}${BUY_COUNT}")
        return lottoCount
    }

    fun transformLottoCountFromInput(input: Int): Int {
        return input / THOUSAND_WON
    }

    fun lastWeekInput(): List<Int> {
        println(ENTER_LAST_WEEK_LOTTO_NUMBER)
        val lastWeekLottoNumber = readln()
        return transformLastWeekLottoListFromInput(lastWeekLottoNumber)
    }

    fun transformLastWeekLottoListFromInput(lastWeekLottoNumber: String): List<Int> {
        val lastWeekLottoNumberList = lastWeekLottoNumber.replace(" ", "").split(DELIMITER)
        return kotlin.runCatching {
            lastWeekLottoNumberList.map { it.toInt() }.sorted()
        }.getOrNull() ?: error(ERROR_TEXT)
    }

    private const val ENTER_LOTTO_PRICE = "구입금액을 입력해 주세요."
    private const val ERROR_TEXT = "올바른 숫자를 입력 해주세요"
    private const val MINIMUM_COUNT = 0
    private const val CHECK_MINIMUM_COUNT_TEXT = "1개 이상을 구매하세요"
    private const val BUY_COUNT = "개를 구매했습니다."
    private const val THOUSAND_WON = 1000
    private const val ENTER_LAST_WEEK_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val DELIMITER = ','
}
