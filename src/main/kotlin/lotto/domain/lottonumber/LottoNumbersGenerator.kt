package lotto.domain.lottonumber

import lotto.domain.LottoNumbers

interface LottoNumbersGenerator {
    fun generate(): LottoNumbers
}
