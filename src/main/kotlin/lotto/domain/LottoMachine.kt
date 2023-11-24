package lotto.domain

object LottoMachine {
    private const val LOTTO_PRICE = 1000
    fun generateLotto(money: Money, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        val lottoCount = money.amount / LOTTO_PRICE
        return (0 until lottoCount).map { Lotto.from(lottoNumberGenerator) }
    }


}
