package lotto.domain.response

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import lotto.domain.LottoQuantity
import lotto.domain.Money

class LottosGenerateRequest(
    val money: Money,
    val manualLottoNumbers: List<LottoNumbers> = emptyList(),
) {
    init {
        validateMoneyIsEnough(money, LottoQuantity(manualLottoNumbers.size))
    }

    private fun validateMoneyIsEnough(money: Money, desiredLottoQuantity: LottoQuantity) {
        val availableLottoQuantity = LottoQuantity(money.value / Lotto.PRICE)
        require(availableLottoQuantity >= desiredLottoQuantity) {
            "금액이 부족합니다."
        }
    }
}
