package lottery.view

import lottery.domain.Lotto

object OutputView {
    private const val PRINT_LOTTERY_AMOUNT_MESSAGE = "개를 구매했습니다."
    private const val SEPARATOR = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"

    fun printLotteryAmount(amount: Int) {
        println("$amount$PRINT_LOTTERY_AMOUNT_MESSAGE")
    }

    fun printTotalLottery(lottos: List<Lotto>) {
        lottos.forEach { println(it.lottoNumber.joinToString(SEPARATOR, PREFIX, POSTFIX)) }
        println()
    }
}
