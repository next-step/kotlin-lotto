package com.nextstep.lotto.domain

internal const val LOTTO_PRICE: Int = 1000
private const val LOTTO_NUMBER_LOWER_BOUND = 1
private const val LOTTO_NUMBER_UPPER_BOUND = 45

class LottoMachine {

    private val lottoNumbers: List<LottoNumber> = (LOTTO_NUMBER_LOWER_BOUND..LOTTO_NUMBER_UPPER_BOUND).map { LottoNumber(it) }

    fun purchase(price: Int): Lottos {
        require(price >= LOTTO_PRICE) { "로또는 1000원부터 구매할 수 있습니다. amount: $price" }
        val lottos = (1..price / LOTTO_PRICE).map { Lotto(randomLottoBalls()) }
        return Lottos(lottos)
    }

    private fun randomLottoBalls(): List<LottoNumber> {
        val shuffledBall = lottoNumbers.shuffled()
        return shuffledBall.subList(0, 6)
    }
}
