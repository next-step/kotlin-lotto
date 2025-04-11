package lotto

import lotto.machine.LottoMachine

class LottoStore {
    fun sell(count: Int, machine: LottoMachine): List<Lotto> {
        return machine.generate(count)
    }
}