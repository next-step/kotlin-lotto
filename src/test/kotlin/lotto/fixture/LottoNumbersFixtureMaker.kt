package lotto.fixture

import lotto.domain.LottoNumber

internal fun createLottoNumbers(vararg items: Int) = items.map(LottoNumber::valueOf).toSet()

internal fun createLottoNumbers(capacity: Int, skipNumber: Int = 0) =
    (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).filter { it != skipNumber }
        .take(capacity)
        .map(LottoNumber::valueOf)
        .toSet()
