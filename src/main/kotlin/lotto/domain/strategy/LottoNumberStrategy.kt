package lotto.domain.strategy

class LottoNumberStrategy : NumberGenerateStrategy {
    override fun generate(): Int {
        return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).random()
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
