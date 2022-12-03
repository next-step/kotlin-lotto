package lotto.domain

import lotto.domain.vo.LottoNumber

class LottoNumbers(numbers: List<Int>) {
    private val lottoNumbers: Set<LottoNumber> = numbers.map { LottoNumber(it) }.toSortedSet()

    init {
        require(lottoNumbers.size == SIZE) { "there is duplicate number" }
    }

    fun countMatchedNumbers(otherLottoNumbers: LottoNumbers): Int {
        return this.lottoNumbers.filter { otherLottoNumbers.lottoNumbers.contains(it) }.size
    }

    fun numbers(): List<Int> = lottoNumbers.map { it.number }

    companion object {
        private const val SIZE = 6
    }
}
