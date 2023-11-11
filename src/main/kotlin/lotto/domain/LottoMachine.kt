package lotto.domain

class LottoMachine(private val lottoPrice: Int) {
    fun sellLotto(pay: Int): List<Lotto> {
        require(pay >= lottoPrice) { SELL_LOTTO_ERROR_MESSAGE }
        return (0 until pay / lottoPrice).map { Lotto(lottoNumberGenerator()) }
    }

    private fun lottoNumberGenerator(): List<LottoNumber> {

        return (0 until 6).map { LottoNumber((START_NUMBER..END_NUMBER).random()) }
    }

    companion object {
        private const val SELL_LOTTO_ERROR_MESSAGE: String = "금액이 부족합니다."
        private const val START_NUMBER: Int = 1
        private const val END_NUMBER: Int = 45
    }
}
