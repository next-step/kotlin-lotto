package lotto

class Lotto private constructor(val lottoNumbers: List<LottoNumber>) {

    init {
        val lottoNumbersSize = lottoNumbers.size
        require(lottoNumbersSize == LOTTO_SIZE)
        require(lottoNumbersSize == lottoNumbers.toSet().size)
    }

    constructor() : this(LottoPreset.shuffled().take(6).sortedBy { it.number })

    constructor(vararg number: Int) : this(number.map { LottoNumber(it) })

    fun countMatch(winningLotto: Lotto): Int {
        return lottoNumbers.intersect(winningLotto.lottoNumbers.toSet()).count()
    }

    override fun toString(): String {
        return "[${lottoNumbers.joinToString(", ")}]"
    }

    companion object {
        private val LottoPreset = List(45) { LottoNumber(it + 1) }
        private const val LOTTO_SIZE = 6
    }
}
