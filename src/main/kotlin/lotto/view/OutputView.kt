package lotto.view

import lotto.domain.Lotto

object OutputView {

    private const val ENTER_MONEY = "구입금액을 입력해 주세요."
    private const val LOTTO_COUNT = "개를 구매했습니다."
    private const val ENTER_JACKPOT_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val LOTTO_STATISTICS = "당첨 통계"
    private const val LINE = "---------"

    fun printEnterMoney() = println(ENTER_MONEY)
    fun printLottoCount(count: String) = println(count + LOTTO_COUNT)
    fun printJackpotNumber() = println(ENTER_JACKPOT_NUMBER)
    fun printLottoStatistics() = println(LOTTO_STATISTICS)
    fun printLine() = println(LINE)

    fun printLottoList(lotto: List<Lotto>) {
        lotto.forEach { println(it.lotto) }
    }
}
