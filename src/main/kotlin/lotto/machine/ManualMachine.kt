package lotto.machine

import lotto.Lotto

class ManualMachine(private val lotts: List<Lotto>): LottoMachine {
    override fun generate(count: Int): List<Lotto> {
        return lotts
    }
}