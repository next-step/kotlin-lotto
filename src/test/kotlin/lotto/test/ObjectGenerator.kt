package lotto.test

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.RandomLottoFactory

object ObjectGenerator {
    fun lotto(vararg number: Int): Lotto {
        val lottoNumbers = lottoNumbers(*number)
        return Lotto(lottoNumbers)
    }

    fun randomLotto(count: Int): List<Lotto> {
        return List(count) { RandomLottoFactory.generate() }
    }

    private fun lottoNumbers(vararg number: Int): List<LottoNumber> {
        return number.toList().map { LottoNumber(it) }
    }
}
