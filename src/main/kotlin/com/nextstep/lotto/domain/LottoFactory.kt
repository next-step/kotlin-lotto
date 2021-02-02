package com.nextstep.lotto.domain

object LottoFactory {
    const val LOTTO_PRICE = 1000

    fun buyLotto(price: Int): List<Lotto> {
        if (isNotPurchaseable(price)) {
            throw IllegalArgumentException("돈이 없어 로또를 구매할 수 없습니다.")
        }
        val numberOfLotto = price.div(LOTTO_PRICE)
        return (1..numberOfLotto).map { drawRandomLotto() }
    }

    private fun isNotPurchaseable(price: Int): Boolean {
        return price < LOTTO_PRICE
    }
    fun drawRandomLotto(): Lotto {
        return Lotto(LottoNumbers.drawRandomNumbers().sortedBy { it.number })
    }

    fun drawManualLotto(lottoNumbers: List<Int>): Lotto {
        return Lotto(lottoNumbers.map { LottoNumbers.valueOf(it) })
    }
}
