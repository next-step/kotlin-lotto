package lotto.view

import lotto.domain.Lottery
import lotto.infra.port.OutputSystem

class BuyResultView(private val outputSystem: OutputSystem, private val lotteries: List<Lottery>) {

    fun printLottos() {
        printLottoCount()
        printAllLotto()
    }

    private fun printLottoCount() {
        outputSystem.write("${lotteries.size}개를 구매했습니다.\n")
    }

    private fun printAllLotto() {
        lotteries.forEach(::printLotto)
    }

    private fun printLotto(lottery: Lottery) = outputSystem.write("${lottery}\n")
}
