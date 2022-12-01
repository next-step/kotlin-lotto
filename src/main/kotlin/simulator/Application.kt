package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.Lotto
import simulator.lotto.LottoMachine
import simulator.lotto.Number
import simulator.lotto.NumberGenerator

fun main() {
    val input = Input()
    val output = Output()
    val generator = NumberGenerator(Number.MIN_NUMBER, Number.MAX_NUMBER, Number.NUMBERS_COUNT)
    val money = input.getMoney()
    val lottos = LottoMachine(generator).create(money / Lotto.PRICE)

    output.printLottos(lottos)

    val winningLotto = Lotto(Number(input.getWinningNumbers()))
    val bonusNumber = input.getBonusNumber()
    val ranks = lottos.ranks(winningLotto,bonusNumber)

    output.printResult(ranks)
    output.printYield(ranks.yield(money))
}