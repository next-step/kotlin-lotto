package lotto.model

class Lottos(
    val lottos: List<Lotto>
) {

    val size = lottos.size

    companion object {
        private const val MIN_PAYMENT_PRICE = 0
        private const val LOTTO_PRICE = 1000

        fun from(paymentPrice: Int): Lottos {
            val lottos = List(paymentPrice.coerceAtLeast(MIN_PAYMENT_PRICE) / LOTTO_PRICE) {
                Lotto(RandomLottoGenerator.generate())
            }
            return Lottos(lottos)
        }
    }
}
