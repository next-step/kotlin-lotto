package lotto.domain

object LottoGenerator {
    private const val MORE_THAN_LOTTO_PRICE_MESSAGE = "${Lotto.LOTTO_PRICE}이상의 금액을 입력해주세요"

    fun generateLottos(amount: Int): Lottos {
        require(amount >= Lotto.LOTTO_PRICE) { MORE_THAN_LOTTO_PRICE_MESSAGE }
        return Lottos(Array(amount / Lotto.LOTTO_PRICE) { RandomLotto() }.toList())
    }
}
