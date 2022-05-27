package lotto

class WinningLotto(private val _lottoNumbers: Set<LottoNumber>) {

    val get: Set<LottoNumber>
        get() = _lottoNumbers.toSet()

    init {
        validate(_lottoNumbers)
    }

    fun matchCount(lottos: Set<LottoNumber>): Int {
        return lottos.count { _lottoNumbers.contains(it) }
    }

    private fun validate(lottoNumbers: Set<LottoNumber>) {
        if (lottoNumbers.size != MIN_SIZE) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MIN_SIZE = 6
    }
}
