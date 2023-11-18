package lotto.domain.purchase

import lotto.domain.Lotto
import lotto.domain.LottoCount

@JvmInline
value class LottoBuyingPrice private constructor(
    val value: Int,
) {

    fun divide(value: Int): Int =
        this.value.div(value)

    fun minus(value: Int): Int =
        this.value.minus(value)

    fun validateManualLottoPurchase(manualLottoCount: LottoCount): LottoBuyingPriceResult {
        val manualLottoPrice = manualLottoCount.multiply(Lotto.LOTTO_PRICE)
        if (value < manualLottoPrice) {
            return LottoBuyingPriceResult.Failure("주어진 구입 금액으로 수동 로또를 구매할 수 없습니다.")
        }
        return LottoBuyingPriceResult.Success(this)
    }

    companion object {
        fun createResult(value: Int): LottoBuyingPriceResult {
            if (value < Lotto.LOTTO_PRICE) {
                return LottoBuyingPriceResult.Failure("로또 구입 금액은 ${Lotto.LOTTO_PRICE}원 이상이어야 합니다.")
            }
            return LottoBuyingPriceResult.Success(LottoBuyingPrice(value))
        }
    }
}
