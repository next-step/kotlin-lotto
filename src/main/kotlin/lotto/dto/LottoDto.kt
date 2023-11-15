package lotto.dto

import lotto.domain.Lotto
import lotto.domain.LottoNumber

data class LottoDto(val lotto: List<LottoNumber>) {
    constructor(lotto: Lotto) : this(lotto.lotto)
}
