package lotto.domain

class LottoResult(
    val lottos: Lottos,
    val lottoOutcome: LottoOutcome,
) {
    companion object {
        fun getLottoResult(
            lottoCustomerInput: LottoCustomerInput,
            winningNumbers: WinningNumbers,
            lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator(),
        ): LottoResult {
            val lottoSeller = LottoSeller(lottoNumberGenerator)
            val lottos = lottoSeller.sellLottos(lottoCustomerInput)
            return LottoResult(lottos, LottoOutcome.of(lottos, winningNumbers))
        }
    }
}
