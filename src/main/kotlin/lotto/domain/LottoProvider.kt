package lotto.domain

import lotto.domain.numbers.LottoNumbers

class LottoProvider(payment: Int, customLottoNumbers: List<LottoNumbers> = emptyList()) {
    val numberOfCustomLottos: Int = when (isAffordable(payment, customLottoNumbers.size)) {
        true -> customLottoNumbers.size
        false -> throw IllegalArgumentException(TOO_MANY_LOTTO_REQUESTED)
    }

    val numberOfAutomaticLottos: Int = payment.getNumberOfAffordableLotto() - numberOfCustomLottos

    val lottos: List<Lotto> = generateCustomLottos(customLottoNumbers) + generateAutomaticLottos(numberOfAutomaticLottos)

    private fun generateCustomLottos(customLottoNumbers: List<LottoNumbers>) = customLottoNumbers.map { Lotto(it) }

    private fun generateAutomaticLottos(numberOfAutomaticLottos: Int) = (1..numberOfAutomaticLottos).map { Lotto() }

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val TOO_MANY_LOTTO_REQUESTED: String = "구매 금액으로 원하는 수의 로또를 구매할 수 없습니다"

        fun isAffordable(payment: Int, numberOfLottoRequested: Int): Boolean = payment.getNumberOfAffordableLotto() >= numberOfLottoRequested

        private fun Int.getNumberOfAffordableLotto(): Int = this / LOTTO_PRICE
    }
}
