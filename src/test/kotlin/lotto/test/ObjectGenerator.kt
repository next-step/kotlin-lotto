package lotto.test

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object ObjectGenerator {
    fun lotto(vararg number: Int): Lotto {
        val lottoNumbers = lottoNumbers(*number)
        return Lotto(lottoNumbers)
    }

    fun lottoNumbers(vararg number: Int): List<LottoNumber> {
        return number.toList().map { LottoNumber(it) }
    }
}
