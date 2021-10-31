package lotto.model

/**
 * 로또를 생성하는 클래스
 * */
class LottoNumberListProcessor(private val price: Price) {
    fun generateLottoList(): List<Lotto> =
        (0 until price.lottoCount)
            .map {
                Lotto(RandomNumberGenerationProcessor.generateNumbers(LottoNumber.getRandomRangeList())
                    .map { LottoNumber((it)) }
                )
            }
}
