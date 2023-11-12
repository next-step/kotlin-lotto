package lotto.dto

import lotto.domain.Lotto

data class LottoDto(val lotto: List<Int>) {
    constructor(lotto: Lotto) : this(lotto.lotto)
}
