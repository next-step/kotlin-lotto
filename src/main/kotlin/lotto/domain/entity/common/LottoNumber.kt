package lotto.domain.entity.common

import lotto.filter.LottoFilter

data class LottoNumber(val number: Int) {

    init {
        LottoFilter.verify(number)
    }
}
