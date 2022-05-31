package lotto.model

class Lottos(
    val lottos: List<Lotto>
) {

    companion object {
        private const val MIN_PAYMENT_PRICE = 0
        private const val LOTTO_PRICE = 1000

        fun from(paymentPrice: Int): Lottos {
            val lottos = List(paymentPrice.coerceAtLeast(MIN_PAYMENT_PRICE) / LOTTO_PRICE) {
                Lotto.generateLotto()
            }
            return Lottos(lottos)
        }
    }
}
