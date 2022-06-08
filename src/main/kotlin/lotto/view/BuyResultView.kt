package lotto.view

import lotto.domain.Lottery
import lotto.infra.port.OutputSystem
import lotto.vo.LotterySet

class BuyResultView(private val outputSystem: OutputSystem) {

    fun printLotteries(lotteries: LotterySet) {
        printLottoCount(lotteries)
        printAllLotto(lotteries)
    }

    private fun printLottoCount(lotteries: LotterySet) {
        outputSystem.write("${lotteries.size}개를 구매했습니다.\n")
    }

    private fun printAllLotto(lotteries: LotterySet) {
        lotteries.forEach(::printLotto)
    }

    private fun printLotto(normalLottery: Lottery) = outputSystem.write("${normalLottery}\n")
}
