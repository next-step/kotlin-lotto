package lotto.model

/**
 * 로또를 생성하는 클래스
 * */
class LottoNumberListGenerator(private val price: Price) {
    fun generateLottoList(): List<Lotto> =
        (0 until price.lottoCount)
            .map {
                Lotto(
                    RandomNumberGenerationProcessor.generateNumbers(range = LottoNumber.getLottoNumberRange())
                        .map { LottoNumber((it)) }
                )
            }
}
