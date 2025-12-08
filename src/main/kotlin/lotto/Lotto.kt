package lotto

data class Lotto(val numbers: List<LottoNumber>) {
    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun createRandom(): Lotto {
            return Lotto(
                (LottoNumber.MINIMUM..LottoNumber.MAXIMUM)
                    .toList()
                    .shuffled()
                    .take(LOTTO_NUMBER_COUNT)
                    .map { LottoNumber(it) },
            )
        }
    }
}
