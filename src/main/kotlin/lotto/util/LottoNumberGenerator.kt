package lotto.util

import lotto.domain.LottoNumber

interface LottoNumberGenerator {
    fun generate(): Set<LottoNumber>
}
