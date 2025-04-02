package lotto.machine

import lotto.Lotto
import lotto.LottoNumber

class AutoMachine {
    fun generate(count: Int): List<Lotto> {
        return List(count) { Lotto(LottoNumber.all().shuffled().take(LOTTO_NUMBER_COUNT)) }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
