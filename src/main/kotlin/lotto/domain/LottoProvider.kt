package lotto.domain

import lotto.domain.numbers.LottoNumbers

class LottoProvider(payment: Int, customLottoNumbers: List<LottoNumbers> = emptyList()) {
    val numberOfCustomLottos: Int
    val numberOfAutomaticLottos: Int

    val lottos: List<Lotto>

    init {
        val totalNumberOfLottos = payment / LOTTO_PRICE

        numberOfCustomLottos = customLottoNumbers.size
            .takeUnless { it > totalNumberOfLottos }
            ?: throw IllegalArgumentException(TOO_MANY_LOTTO_REQUESTED)

        numberOfAutomaticLottos = totalNumberOfLottos - numberOfCustomLottos

        lottos = generateCustomLottos(customLottoNumbers) + generateAutomaticLottos(numberOfAutomaticLottos)
    }

    private fun generateCustomLottos(customLottoNumbers: List<LottoNumbers>) = customLottoNumbers.map { Lotto(it) }

    private fun generateAutomaticLottos(numberOfAutomaticLottos: Int) = (1..numberOfAutomaticLottos).map { Lotto() }

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val TOO_MANY_LOTTO_REQUESTED: String = "구매 금액을 초과하는 로또를 요청했습니다"
    }
}
