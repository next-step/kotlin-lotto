package lotto.domain

import lotto.domain.LottoConstants.LOTTE_PRICE

object LottoFactory {
    fun purchaseLotto(cash: Cash): Lottos {
        val lottoCount: Int = cash.amount / LOTTE_PRICE
        return Lottos(List(lottoCount) { Lotto() })
    }

    fun purchaseLotto(cash: Cash, manualLottos: Lottos): Lottos {
        val remainCash = cash.pay(manualLottos.count * LOTTE_PRICE)
        val autoLottos = purchaseLotto(remainCash)
        return manualLottos.join(autoLottos)
    }
}
