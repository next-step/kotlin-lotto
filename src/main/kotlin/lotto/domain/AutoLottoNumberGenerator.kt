package lotto.domain

class AutoLottoNumberGenerator : LottoNumberGenerator {
    override fun generateNumber(): List<LottoNumber> {
        val numberSet = mutableSetOf<Int>()
        while (numberSet.size < MAX_LOTTO_NUMBER_AMOUNT) {
            numberSet.add((START_NUMBER..END_NUMBER).random())
        }

        return numberSet.map { LottoNumber(it) }
    }

    companion object {
        private const val START_NUMBER: Int = 1
        private const val END_NUMBER: Int = 45
        private const val MAX_LOTTO_NUMBER_AMOUNT: Int = 6
    }
}
