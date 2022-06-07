package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class LottoService {

    fun buy(n: Int): List<Lotto> {
        return (1..n).map { buy() }
    }

    private fun buy(): Lotto {
        return Lotto(LottoNumber.numbers.shuffled().take(Lotto.LOTTO_NUMBERS).sortedBy { it.value })
    }
}
