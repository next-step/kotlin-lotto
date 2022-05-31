package lotto.domain

class LottoProvider(payment: Int) {
    val numberOfLottos: Int = payment / LOTTO_PRICE
    val lottos: List<Lotto> = (1..numberOfLottos).map { Lotto() }

    companion object {
        const val LOTTO_PRICE: Int = 1000
    }
}
