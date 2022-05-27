package lotto.domain

class LottoProvider(payment: Int) {
    val numberOfLottos: Int = payment / Lotto.PRICE
    val lottos: List<Lotto> = (1..numberOfLottos).map { Lotto() }
}
