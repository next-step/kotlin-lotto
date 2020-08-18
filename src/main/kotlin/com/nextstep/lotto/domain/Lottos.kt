package com.nextstep.lotto.domain

data class Lottos private constructor(val lottos: List<Lotto>) {

    fun findMatchResult(winningLotto: WinningLotto): Map<Int, Int> {
        return lottos.map { winningLotto.findNumberOfMatch(it) }
            .groupingBy { it }.eachCount()
    }

    companion object {
        const val LOTTO_PRICE = 1000

        fun buyLotto(price: Int): Lottos {
            if (isNotPurchaseable(price)) {
                throw IllegalArgumentException("돈이 없어 로또를 구매할 수 없습니다.")
            }
            val numberOfLotto = price.div(LOTTO_PRICE)
            return Lottos((1..numberOfLotto).map { LottoFactory.drawRandomLotto() })
        }

        private fun isNotPurchaseable(price: Int): Boolean {
            return price < LOTTO_PRICE
        }
    }
}
