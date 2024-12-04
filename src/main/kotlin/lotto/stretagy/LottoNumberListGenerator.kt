package lotto.stretagy

import lotto.domain.LottoNumber

interface LottoNumberListGenerator {
    fun generate(): Set<LottoNumber>
}
