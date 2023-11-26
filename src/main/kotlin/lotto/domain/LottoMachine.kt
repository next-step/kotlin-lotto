package lotto.domain

object LottoMachine {
    fun generateLotto(buy: Buy, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        return (0 until buy.getCounts()).map { Lotto.from(lottoNumberGenerator) }
    }
}
