package lotto.domain

import lotto.constants.Sort
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_SIZE

class LottoNumberAutoGenerator(private val shuffleNumber: ShuffleNumber) {

    fun takeShuffleNumber(sort: Sort = Sort.ASC): LottoNumbers {
        return LottoNumbers(
            generateLottoNumbers().take(LOTTO_NUMBER_SIZE)
                .numberSort(sort)
        )
    }

    private fun generateLottoNumbers(): List<LottoNumber> = shuffleNumber.shuffleNumber(LOTTO_POOL)

    private fun List<LottoNumber>.numberSort(sort: Sort): List<LottoNumber> {
        if (sort == Sort.DESC) {
            return this.sortedByDescending { it.number }
        }
        return this.sortedBy(LottoNumber::number)
    }

    companion object {
        private val LOTTO_POOL = listOf(LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX)
            .flatten()
            .map { LottoNumber(it) }
    }
}
