package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.Number
import simulator.lotto.Numbers
import simulator.lotto.Ranks
import simulator.lotto.WinningNumber

class Simulator(
    private val input: Input,
    private val output: Output
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
            .map { stringToNumbers(it) } + createRandomNumbers(count - manualCount)

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

    private fun createRandomNumbers(times: Int): List<Numbers> {
        val numberRange = (Number.MIN_NUMBER..Number.MAX_NUMBER)

        return List(times) {
            Numbers(
                numberRange.shuffled()
                    .slice(0 until Numbers.NUMBERS_COUNT)
                    .map { Number(it) }
            )
        }
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