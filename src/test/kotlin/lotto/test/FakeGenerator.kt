package lotto.test

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.RandomLottoFactory

object FakeGenerator {
    fun lotto(vararg number: Int): Lotto {
        val lottoNumbers = lottoNumbers(*number)
        return Lotto(lottoNumbers)
    }

    fun lottoNumbers(vararg number: Int): List<LottoNumber> {
        return number.toList().map { LottoNumber(it) }
    }

    fun lottos(count: Int): List<Lotto> {
        return List(count) { RandomLottoFactory.generate() }
    }

    fun lottoNumbersOfLottos(count: Int): List<List<LottoNumber>> {
        return lottos(count).map { it.lottoNumbers }
    }
}
