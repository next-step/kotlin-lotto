package lotto.domain

import java.util.SortedSet

class Lotto private constructor(val lottoNumbers: SortedSet<LottoNumber>) {
    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        fun of(lottoNumbers: List<LottoNumber>): Lotto {
            val sortedAndDistincted = lottoNumbers.toSortedSet()
            require(sortedAndDistincted.size == LOTTO_NUMBER_COUNT) { "로또 번호는 총 ${LOTTO_NUMBER_COUNT}개가 입력 되어야 합니다." }
            return Lotto(sortedAndDistincted)
        }
    }
}
