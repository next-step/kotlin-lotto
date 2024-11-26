package lotto.step3

import lotto.step3.domain.Lotto
import lotto.step3.domain.LottoNumber

object LottoStub {
    fun get(numbers: List<Int> = (1..45).shuffled().take(6).sorted()): Lotto {
        return Lotto.of(numbers = numbers.map { LottoNumber(it) })
    }
}
