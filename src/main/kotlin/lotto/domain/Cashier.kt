package lotto.domain

import lotto.stretagy.LottoNumberListGenerator

class Cashier(
    private val amount: Int,
    private val lottoNumberListGenerator: LottoNumberListGenerator,
) {
    fun purchaseAutoLottos(): LottoTicket {
        require(amount >= LOTTO_PRICE)
        val numberOfLotto = calculateNumberOfLotto(amount)
        return LottoTicket(
            List(numberOfLotto) { Lotto(lottoNumberListGenerator.generate()) },
        )
    }

    fun purchaseManualLottos(manualLottoNumbers: List<Set<Int>>): LottoTicket {
        val availablePurchaseLottoNumber = amount / LOTTO_PRICE
        require(manualLottoNumbers.size == availablePurchaseLottoNumber) {
            INVALID_MONEY
        }

        val lottos =
            manualLottoNumbers.map {
                LottoNumber.of(it)
            }.map { Lotto(it) }.toList()

        return LottoTicket(lottos)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val INVALID_MONEY = "수동 로또 개수와 금액이 일치하지 않습니다."

        private fun calculateNumberOfLotto(amount: Int): Int {
            return amount / LOTTO_PRICE
        }
    }
}
