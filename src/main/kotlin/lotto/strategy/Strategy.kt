package lotto.strategy

import lotto.domain.value.LottoNumber

interface Strategy {
    fun shuffle(numbers: List<LottoNumber>): List<LottoNumber>
}
