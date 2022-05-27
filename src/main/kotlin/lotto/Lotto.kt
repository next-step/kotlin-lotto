package lotto

class Lotto(private val _lotto: HashSet<LottoNumber>) {

    init {
        validate(_lotto)
    }

    val get: HashSet<LottoNumber>
        get() = HashSet(_lotto)

    private fun validate(lotto: HashSet<LottoNumber>) {

        if (lotto.size != MIN_SIZE) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MIN_SIZE = 6
    }
}
