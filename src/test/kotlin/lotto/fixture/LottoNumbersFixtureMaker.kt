package lotto.fixture

import lotto.domain.LottoNumber

internal object LottoNumbersFixtureMaker {
    internal fun createLottoNumbers(vararg items: Int) = items.map(LottoNumber::valueOf).toSet()

    internal fun createLottoNumbers(capacity: Int) = (1..capacity).map(LottoNumber::valueOf).toSet()
}
