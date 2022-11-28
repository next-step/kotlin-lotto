package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.*

fun main() {
    val input = Input()
    val output = Output()
    val generator = NumberGenerator(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBERS_COUNT)
    val money = input.getMoney()
    val lottos = LottoMachine(generator).create(money / Lotto.PRICE)

    output.printLottos(lottos)

    val winningLotto = Lotto(input.getWinningNumbers())
    val bonusNumber = input.getBonusNumber()
    val ranks = lottos.ranks(winningLotto,bonusNumber)

    output.printResult(ranks)
    output.printYield(ranks.yield(money))
}