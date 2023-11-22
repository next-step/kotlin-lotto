package lotto.domain

class AutoLottoNumberGenerator : LottoNumberGenerator {
    override fun generateNumber(): List<LottoNumber> {
        return (START_NUMBER..END_NUMBER).shuffled()
            .take(MAX_LOTTO_NUMBER_AMOUNT)
            .map(::LottoNumber)
    }

    companion object {
        private const val START_NUMBER: Int = 1
        private const val END_NUMBER: Int = 45
        private const val MAX_LOTTO_NUMBER_AMOUNT: Int = 6
    }
}
