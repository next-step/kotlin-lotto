package lotto.domain

import lotto.domain.vo.LottoNumber

class LottoNumbers(private val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == SIZE) { "there is duplicate number" }
    }

    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber(it) }.toSortedSet())

    fun countMatchedNumbers(otherLottoNumbers: LottoNumbers): Int {
        return this.lottoNumbers.count { it in otherLottoNumbers.lottoNumbers }
    }

    fun numbers(): List<Int> = lottoNumbers.map { it.number }

    companion object {
        internal const val SIZE = 6
    }
}
