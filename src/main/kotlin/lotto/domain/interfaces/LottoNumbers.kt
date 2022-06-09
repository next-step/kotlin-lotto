package lotto.domain.interfaces

import lotto.domain.LottoNumber

interface LottoNumbers {
    fun createNumbers(): Set<LottoNumber> {
        return emptySet()
    }
    fun convertLottoNumbers(numbers: List<Int>): Set<LottoNumber> {
        return emptySet()
    }

    companion object {
        const val MIN_LOTTO_INDEX = 0
        const val MAX_LOTTO_INDEX = 6
    }
}
