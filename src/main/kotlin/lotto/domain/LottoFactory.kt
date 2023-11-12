package lotto.domain

object LottoFactory {
    fun generateLottoList(count: Int, numberGenerator: NumberGenerator = RandomNumberGenerator()): List<Lotto> =
        List(count) {
            Lotto(
                LottoNumbers(
                    numberGenerator.generateNumbers(
                        startNumber = LottoNumbers.LOTTO_START_NUMBER,
                        endNumber = LottoNumbers.LOTTO_END_NUMBER,
                        count = LottoNumbers.LOTTO_NUMBER_SIZE
                    )
                )
            )
        }
}
