package lotto.domain

import lotto.constants.Sort

class LottoNumberGenerator(private val shuffleNumber: ShuffleNumber) {

    fun takeShuffleNumber(
        numbers: List<LottoNumber>,
        takeCount: Int,
        sort: Sort = Sort.ASC
    ): LottoNumbers {
        return LottoNumbers(
            generateLottoNumbers(numbers).take(takeCount)
                .numberSort(sort)
        )
    }

    private fun generateLottoNumbers(numbers: List<LottoNumber>): List<LottoNumber> =
        shuffleNumber.shuffleNumber(numbers)

    private fun List<LottoNumber>.numberSort(sort: Sort): List<LottoNumber> {
        if (sort == Sort.DESC) {
            return this.sortedByDescending { it.number }
        }
        return this.sortedBy(LottoNumber::number)
    }
}
