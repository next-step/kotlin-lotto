package lotto.model.strategy

import lotto.model.LottoNumber

interface LottoNumberStrategy {
    fun pick(): LottoNumber
}
