package lotto

class LottoNumberGenerator : NumberGenerator {
    override fun generate(): Set<Int> {
        return generateSequence {
            (LottoNumberValidator.LOTTO_RANGE).random()
        }.distinct().take(6).toSet()
    }
}
