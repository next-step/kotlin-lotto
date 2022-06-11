package lotto.domain.fixture

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object LottoFixture {
    fun createLotto(lottoNumbers: List<Int>): Lotto {
        return Lotto(lottoNumbers.map { LottoNumber(it) })
    }
}
