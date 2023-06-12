package lotto.fixture

import lotto.domain.Lotto
import lotto.fixture.LottoNumbersFixtureMaker.createLottoNumbers

object LottoFixtureGenerator {
    fun createLotto(numbers: List<Int>): Lotto = createLottoNumbers(numbers).let(::Lotto)
}
