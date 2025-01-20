package lotto.domain

class Lotto private constructor(val lottoNumbers: Set<LottoNumber>) {

    init {
        val lottoNumbersSize = lottoNumbers.size
        require(lottoNumbersSize == LOTTO_SIZE)
    }

    constructor() : this(
        LottoPreset.shuffled()
            .take(6)
            .sortedBy { it.number }
            .toSet()
    )

    constructor(vararg number: Int) : this(
        number.map(::LottoNumber)
            .toSet()
    )

    fun countMatch(winningLotto: Lotto): Int {
        return lottoNumbers.intersect(winningLotto.lottoNumbers)
            .count()
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in lottoNumbers
    }

    companion object {
        private val LottoPreset = List(LottoNumber.END_LOTTO_NUMBER) { LottoNumber(it + 1) }
        private const val LOTTO_SIZE = 6
    }
}
