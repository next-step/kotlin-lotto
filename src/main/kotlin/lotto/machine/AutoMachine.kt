package lotto.machine

import lotto.Lotto
import lotto.LottoNumber

class AutoMachine : Machine {
    override fun generate(): Lotto {
        return Lotto((1..45).map { LottoNumber(it) }.shuffled().take(6))
    }
}
