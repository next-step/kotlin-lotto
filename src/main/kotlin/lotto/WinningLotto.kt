package lotto

class WinningLotto(private val _lottoNumbers: HashSet<LottoNumber>) {

    val get: HashSet<LottoNumber>
        get() = _lottoNumbers.toHashSet()

    init {
        validate(_lottoNumbers)
    }

    private fun validate(lottoNumbers: HashSet<LottoNumber>) {
        if (lottoNumbers.size != MIN_SIZE) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MIN_SIZE = 6
    }
}
