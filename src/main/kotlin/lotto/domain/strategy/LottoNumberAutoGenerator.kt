package lotto.domain.strategy

import lotto.domain.LottoNumbers

interface LottoNumberAutoGenerator {

    fun generate(): LottoNumbers
}
