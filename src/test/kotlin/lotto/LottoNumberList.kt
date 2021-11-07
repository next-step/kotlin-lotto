package lotto

import lotto.domain.LottoNumber

class LottoNumberList {
    companion object {
        fun lottoNumberListOf(vararg ints: Int) = ints.map { LottoNumber(it) }
    }
}
