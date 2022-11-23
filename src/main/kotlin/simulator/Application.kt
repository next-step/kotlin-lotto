package simulator

import simulator.io.Input
import simulator.io.Output
import simulator.lotto.Lotto
import simulator.lotto.LottoMachine
import simulator.lotto.LottoResult
import simulator.lotto.Rank

fun main() {
    val input = Input()
    val output = Output()

    val machine = LottoMachine()

    val money = input.getMoney()
    val times = money / LOTTO_PRICE

    val lottos = machine.create(times)

    output.printTimes(times)
    output.printLottos(lottos)

    val winningLotto = Lotto(input.getLotto().toSet())
    val lottoResult = LottoResult.aggregate(lottos, winningLotto)

    output.printLottoResultHeader()
    Rank.values()
        .reversed()
        .forEach { output.printLottoResult(it.matches(), it.prize(), lottoResult.rankCount(it)) }
    output.printYield(lottoResult.yield(money))
}

const val LOTTO_PRICE = 1000