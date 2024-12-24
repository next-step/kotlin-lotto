package lotto

class Lotto private constructor(val lottoNumbers: List<LottoNumber>) {

    init {
        val lottoNumbersSize = lottoNumbers.size
        require(lottoNumbersSize == LOTTO_SIZE)
        require(lottoNumbersSize == lottoNumbers.toSet().size)
    }

    constructor() : this((1..45).shuffled().take(6).sorted().map { LottoNumber(it) })

    constructor(vararg number: Int) : this(number.map { LottoNumber(it) })

    fun countMatch(winningLotto: Lotto): Int {
        return lottoNumbers.intersect(winningLotto.lottoNumbers.toSet()).count()
    }

    override fun toString(): String {
        return "[${lottoNumbers.joinToString(", ")}]"
    }

    companion object {
        private const val LOTTO_SIZE = 6
    }
}
