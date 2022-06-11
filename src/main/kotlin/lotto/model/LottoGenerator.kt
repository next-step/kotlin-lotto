package lotto.model

object LottoGenerator {
    private const val LOTTO_PRICE = 1000

    fun generateLottos(
        paymentPrice: Int,
        customLottos: Lottos,
        lottoGeneratingStrategy: LottoGeneratingStrategy = RandomLottoGenerating
    ): Lottos {
        val customLottoPrice = customLottos.count * LOTTO_PRICE

        validateMinPaymentPrice(paymentPrice, customLottoPrice)

        val restLottoPaymentPrice = paymentPrice - customLottoPrice
        val restLottoCount = restLottoPaymentPrice / LOTTO_PRICE
        val restLottos = lottoGeneratingStrategy.generateLottos(restLottoCount)

        return customLottos.plus(restLottos)
    }

    private fun validateMinPaymentPrice(paymentPrice: Int, customLottoPrice: Int) =
        require(paymentPrice >= customLottoPrice) { "구입금액은 최소 ${customLottoPrice}원 이상이어야 합니다." }
}
