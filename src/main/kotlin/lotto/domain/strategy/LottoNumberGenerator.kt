package lotto.domain.strategy

import lotto.domain.LottoNumbers

interface LottoNumberGenerator {

    fun generate(): LottoNumbers
}
