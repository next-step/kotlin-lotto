package lotto.domain

class LottoMachine(
    private val lottoPrice: Int,
    private val lottoNumberGenerator: LottoNumberGenerator
) {
    private fun createLotto(amount: Int): List<Lotto> {
        return (0 until amount)
            .map { LottoNumbers(lottoNumberGenerator.generateNumber()) }
            .map { Lotto(it) }
    }

    fun sellLotto(pay: Int, manualNumber: List<String> = arrayListOf()): List<Lotto> {
        val remainPay = pay - (lottoPrice * manualNumber.size)
        validatePay(pay, remainPay)

        val manualLottos = createManualLotto(manualNumber)
        val autoLottos = createLotto(remainPay / lottoPrice)

        return manualLottos + autoLottos
    }

    private fun validatePay(pay: Int, remainPay: Int) {
        require(pay >= lottoPrice) { SELL_LOTTO_ERROR_MESSAGE }
        require(remainPay <= pay) { SELL_LOTTO_ERROR_MESSAGE }
    }

    private fun createManualLotto(manualNumbers: List<String>): List<Lotto> {
        return manualNumbers.map { it ->
            LottoNumbers(
                it.split(",")
                .map { it.toInt() }
                .map { LottoNumber(it) }
            )
        }.map { Lotto(it) }
    }

    companion object {
        private const val SELL_LOTTO_ERROR_MESSAGE: String = "금액이 부족합니다."
    }
}
