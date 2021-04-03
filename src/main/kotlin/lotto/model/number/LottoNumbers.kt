package lotto.model.number

import java.util.TreeSet

data class LottoNumbers private constructor(private val lottoNumbers: TreeSet<LottoNumber>) : Set<LottoNumber> by lottoNumbers {
    init {
        require(lottoNumbers.size == CANDIDATE_SIZE) { "로또 티켓은 6개의 로또 숫자로 이루어져 있다" }
    }

    constructor(lottoNumbers: List<Int>) : this(TreeSet(lottoNumbers.map { LottoNumber.get(it) }))

    constructor(vararg lottoNumbers: Int) : this(lottoNumbers.toList())

    fun countMatch(targetNumbers: LottoNumbers): Int {
        return lottoNumbers.filter {
            targetNumbers.contains(it)
        }.count()
    }

    fun isMatch(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        const val CANDIDATE_SIZE = 6
    }
}
