package lotto.domain

object LottoFactory {
    fun generateLottoList(count: Int, numberGenerator: NumberGenerator = RandomNumberGenerator()): List<LottoNumbers> =
        List(count) {
            LottoNumbers(
                numberGenerator.generateNumbers(
                    startNumber = LottoNumber.LOTTO_START_NUMBER,
                    endNumber = LottoNumber.LOTTO_END_NUMBER,
                    count = LottoNumbers.LOTTO_NUMBER_SIZE
                )
            )
        }
}
