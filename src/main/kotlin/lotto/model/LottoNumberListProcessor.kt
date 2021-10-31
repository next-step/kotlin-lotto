package lotto.model

/**
 * 로또 생성하는 것을 관리하는 클래스
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
