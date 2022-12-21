package lotto.domain

import lotto.domain.vo.LottoNumber

class LottoNumbers(private val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == SIZE) { "there is duplicate number" }
    }

    constructor(numbers: List<Int>) : this(numbers.map { LottoNumber(it) }.toSortedSet())
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) }.toSortedSet())

    fun countMatchedNumbers(otherLottoNumbers: LottoNumbers): Int {
        return this.lottoNumbers.count { it in otherLottoNumbers.lottoNumbers }
    }

    fun numbers(): List<Int> = lottoNumbers.map { it.number }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        internal const val SIZE = 6
    }
}
