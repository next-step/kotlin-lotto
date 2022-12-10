package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.*
import simulator.lotto.Number

class Simulator(
    private val input: Input,
    private val output: Output,
    private val generator: NumberGenerator
) {
    fun run() {
        val money = input.getMoney()
        val count = money / LOTTO_PRICE
        val manualCount = input.getManualCount()

        val lottoList = generateLotto(manualCount, count)
        matches(lottoList, money)
    }

    private fun generateLotto(manualCount: Int, count: Int): List<Numbers> {
        val lottoList = input.getManualNumbers(manualCount)
            .map { stringToNumbers(it) } + LottoMachine(generator).create(count)

        output.printTimes(manualCount, count - manualCount)
        output.printLottoList(lottoList)

        return lottoList
    }

    private fun matches(lottoList: List<Numbers>, money: Int) {
        val winningNumber = WinningNumber(
            stringToNumbers(input.getLastMatchNumbers()),
            Number(input.getBonusNumber())
        )
        val ranks = Ranks.match(lottoList, winningNumber)

        output.printResult(ranks)
        output.printYield(ranks.yield(money))
    }

    private fun stringToNumbers(string: String): Numbers {
        return Numbers(string.split(",").map {
            Number(it.toInt())
        })
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}