package lotto.machine

import lotto.Lotto
import lotto.LottoNumber

class AutoMachine {
    fun generate(count: Int): List<Lotto> {
        return List(count) { Lotto((1..45).map { LottoNumber(it) }.shuffled().take(6)) }
    }
}
