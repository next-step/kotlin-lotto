package lotto

import lotto.number.Numbers

class LottoMachine {
    fun generate(lottoCount: Int): Lottos = Lottos(lottoCount)

    fun generateByManual(numbers: List<Numbers>): Lottos = Lottos(lottos = numbers.map { Lotto(numbers = it) }.toList())
}
