package com.nextstep.lotto.domain

private const val LOTTO_PRICE: Int = 1000

class LottoMachine {

    private val lottoBalls: List<LottoBall> = (1..45).map { LottoBall(it) }

    fun purchase(amount: Int): LottoTickets {
        require(amount >= 1000) { "로또는 1000원부터 구매할 수 있습니다. amount: $amount" }
        val count = amount / LOTTO_PRICE
        val lottoTickets = (1..count).map { LottoTicket(randomLottoBalls()) }
        return LottoTickets(lottoTickets)
    }

    private fun randomLottoBalls(): List<LottoBall> {
        val shuffledBall = lottoBalls.shuffled()
        return shuffledBall.subList(0, 6)
    }
}
