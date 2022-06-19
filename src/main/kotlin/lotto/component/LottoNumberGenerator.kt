package lotto.component

import lotto.domain.LottoNumber

interface LottoNumberGenerator {
    fun generate(): List<LottoNumber>
}
