package lotto.domain

import lotto.error.ErrorMessage.MIN_LOTTO_COUNT

class LottoPurchaseManager {

    fun getLottoCount(money: Int): Int {
        val lottoTryCount = money.div(LOTTO_PRICE)
        require(lottoTryCount > 0) { MIN_LOTTO_COUNT.message }
        return lottoTryCount
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
