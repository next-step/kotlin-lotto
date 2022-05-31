package lotto

class Lotto(val lotto: Set<LottoNumber> = emptySet()) {

    init {
        validate(lotto)
    }

    private fun validate(lotto: Set<LottoNumber>) {
        if (lotto.size != MIN_SIZE) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val MIN_SIZE = 6
    }
}
