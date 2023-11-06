package lotto.domain

import lotto.constants.Sort
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_SIZE

class LottoNumberAutoGenerator(private val shuffleNumber: ShuffleNumber) {

    fun takeShuffleNumber(
        numbers: List<LottoNumber>,
        sort: Sort = Sort.ASC
    ): LottoNumbers {
        return LottoNumbers(
            generateLottoNumbers(numbers).take(LOTTO_NUMBER_SIZE)
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
