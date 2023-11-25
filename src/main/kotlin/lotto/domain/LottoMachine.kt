package lotto.domain

object LottoMachine {
    fun generateLotto(money: Money, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        return (0 until money.getCounts()).map { Lotto.from(lottoNumberGenerator) }
    }
}
