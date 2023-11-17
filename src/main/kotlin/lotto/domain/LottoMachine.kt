package lotto.domain

class LottoMachine(
    private val lottoPrice: Int,
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    fun sellLotto(pay: Int): List<Lotto> {
        require(pay >= lottoPrice) { SELL_LOTTO_ERROR_MESSAGE }
        return createLotto(pay / lottoPrice)
    }

    private fun createLotto(amount: Int): List<Lotto> {
        return (0 until amount)
            .map { LottoNumbers(lottoNumberGenerator.generateNumber()) }
            .map { Lotto(it) }
    }

    companion object {
        private const val SELL_LOTTO_ERROR_MESSAGE: String = "금액이 부족합니다."
    }
}
