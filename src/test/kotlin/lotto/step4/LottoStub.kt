package lotto.step4

import lotto.step4.domain.Lotto
import lotto.step4.domain.LottoNumber

object LottoStub {
    fun get(numbers: List<Int> = (1..45).shuffled().take(6).sorted()): Lotto {
        return Lotto.of(numbers = numbers.map { LottoNumber(it) })
    }
}
