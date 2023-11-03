package lotto.domain

import lotto.constants.Sort

interface ShuffleNumber {

    fun shuffleNumber(): List<Int>
    fun takeShuffleNumber(takeCount: Int, sort: Sort = Sort.ASC): LottoNumbers {
        return LottoNumbers(
            shuffleNumber().take(takeCount)
                .map { LottoNumber(it) }
                .numberSort(sort)
        )
    }

    private fun List<LottoNumber>.numberSort(sort: Sort): List<LottoNumber> {
        if (sort == Sort.DESC) {
            return this.sortedByDescending { it.number }
        }
        return this.sortedBy(LottoNumber::number)
    }
}
