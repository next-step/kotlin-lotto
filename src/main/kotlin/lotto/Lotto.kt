package lotto

class Lotto(lotto: Set<LottoNumber> = emptySet()) {

    init {
        validate(lotto)
    }

    private val _lotto: MutableSet<LottoNumber> = lotto.toMutableSet()
    val lotto: Set<LottoNumber>
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
