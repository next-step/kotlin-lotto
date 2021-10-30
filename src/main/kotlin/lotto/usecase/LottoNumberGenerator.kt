package lotto.usecase

class LottoNumberGenerator : Generator {

    override fun generate(): List<Int> {
        return LOTTO_NUMBER_SIZE.map {
            LOTTO_NUMBER_RANGE.random()
        }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = (1..45)
        private val LOTTO_NUMBER_SIZE = (1..6)
    }
}
