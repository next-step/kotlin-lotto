package lotto.view

import lotto.domain.Lottery
import lotto.domain.NormalLottery
import lotto.infra.port.OutputSystem
import lotto.vo.LottoSet

class BuyResultView(private val outputSystem: OutputSystem, private val lotteries: LottoSet<NormalLottery>) {

    fun printLotteries() {
        printLottoCount()
        printAllLotto()
    }

    private fun printLottoCount() {
        outputSystem.write("${lotteries.size}개를 구매했습니다.\n")
    }

    private fun printAllLotto() {
        lotteries.forEach(::printLotto)
    }

    private fun printLotto(normalLottery: Lottery<NormalLottery>) = outputSystem.write("${normalLottery}\n")
}
