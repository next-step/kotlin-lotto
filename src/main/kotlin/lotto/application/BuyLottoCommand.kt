package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoPayment

data class BuyLottoCommand(
    val payment: LottoPayment,
    val manualLotto: Lotto,
) {
    init {
        require(payment.numberOfLines >= manualLotto.numberOfLines) { "수동으로 구매한 로또의 수가 금액보다 많습니다." }
    }
}
