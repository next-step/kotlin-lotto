package lotto.machine

import lotto.Lotto

interface LottoMachine {
    fun generate(count: Int): List<Lotto>
}
