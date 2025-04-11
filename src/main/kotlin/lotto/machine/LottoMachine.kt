package lotto.machine

import lotto.Lotto
import lotto.Order

interface LottoMachine {
    fun generate(order: Order): List<Lotto>
}
