package lotto

class Lotto(private val _lotto: Set<LottoNumber>) {

    init {
        validate(_lotto)
    }

    val numbers: Set<LottoNumber>
        get() = _lotto.toSet()

    private fun validate(lotto: Set<LottoNumber>) {
        if (lotto.size != MIN_SIZE) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MIN_SIZE = 6
    }
}
