package com.nextstep.lotto.domain

private const val LOTTO_PRICE: Int = 1000

class LottoMachine {

    private val lottoNumbers: List<LottoNumber> = (1..45).map { LottoNumber(it) }

    fun purchase(amount: Int): Lottos {
        require(amount >= 1000) { "로또는 1000원부터 구매할 수 있습니다. amount: $amount" }
        val count = amount / LOTTO_PRICE
        val lottos = (1..count).map { Lotto(randomLottoBalls()) }
        return Lottos(lottos)
    }

    private fun randomLottoBalls(): List<LottoNumber> {
        val shuffledBall = lottoNumbers.shuffled()
        return shuffledBall.subList(0, 6)
    }
}
