package lotto.domain.`interface`

import lotto.domain.LottoNumber

interface LottoNumbers {
    open fun createNumbers(inputs: List<Int>? = null): Set<LottoNumber>

    companion object {
        const val MIN_LOTTO_INDEX = 0
        const val MAX_LOTTO_INDEX = 6
    }
}
