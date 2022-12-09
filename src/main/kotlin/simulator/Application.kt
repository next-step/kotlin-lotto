package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.*
import simulator.lotto.Number

fun main() {
    val input = Input()
    val output = Output()
    val generator = NumberGenerator(Number.MIN_NUMBER, Number.MAX_NUMBER, Numbers.NUMBERS_COUNT)
    val money = input.getMoney()
    val lottoList = LottoMachine(generator).create(money / Lotto.PRICE)

    output.printLottoList(lottoList)

    val numbers = input.getWinningNumbers()
    val bonusNumber = input.getBonusNumber()

    val ranks = Ranks.match(lottoList, WinningNumber(numbers, bonusNumber))

    output.printResult(ranks)
    output.printYield(ranks.yield(money))
}