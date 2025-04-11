package lotto

import lotto.machine.LottoMachine

class LottoStore {
    fun sell(
        order: Order,
        machine: LottoMachine,
    ): List<Lotto> {
        return machine.generate(order)
    }
}
