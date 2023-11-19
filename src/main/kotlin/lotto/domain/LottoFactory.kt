package lotto.domain

object LottoFactory {
    fun generateLottoList(numbers: List<Set<Int?>>): List<LottoNumbers> {
        return numbers.map { set ->
            LottoNumbers(
                set.map { LottoNumber(it) }.toSet()
            )
        }
    }

    fun generateLottoList(
        count: LottoCount,
        numberGenerator: NumberGenerator = RandomNumberGenerator()
    ): List<LottoNumbers> =
        count.value?.let {
            List(it) {
                LottoNumbers(
                    numberGenerator.generateNumbers(
                        startNumber = LottoNumber.LOTTO_START_NUMBER,
                        endNumber = LottoNumber.LOTTO_END_NUMBER,
                        count = LottoNumbers.LOTTO_NUMBER_SIZE
                    )
                )
            }
        } ?: emptyList()
}
