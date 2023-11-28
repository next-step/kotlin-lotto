package lotto.model.strategy

import lotto.model.LottoNumber

interface LottoNumbersStrategy {
    fun pick(): Set<LottoNumber>
}
