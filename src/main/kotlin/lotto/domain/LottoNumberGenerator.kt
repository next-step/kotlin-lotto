package lotto.domain

class LottoNumberGenerator : NumberGenerator {

    override fun generate(): List<Int> {
        return (MIN..MAX)
            .shuffled()
            .take(LOTTO_SIZE)
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
