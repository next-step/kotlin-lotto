package lotto.domain

import lotto.domain.Lotto.Companion.PRICE
import lotto.model.LottoNumber
import lotto.model.LottoNumbers

class LottoTicket private constructor(
    private val purchaseAmount: Int,
    val manualLottoNumbers: List<LottoNumbers>,
) {
    val autoLottoNumbersSize: Int
        get() = (purchaseAmount / PRICE) - manualLottoNumbers.size

    val manualLottoNumbersSize: Int
        get() = manualLottoNumbers.size

    init {
        require(purchaseAmount >= PRICE) { "로또를 구매하려면 최소 ${PRICE}원 이상의 금액이 필요합니다." }
        require((purchaseAmount / PRICE) >= manualLottoNumbers.size) { "수동으로 구매할 로또 수가 구매 금액을 초과할 수 없습니다." }
    }

    companion object {
        operator fun invoke(purchaseAmount: Int, manualLottoNumbers: List<List<Int>> = emptyList()): LottoTicket =
            LottoTicket(purchaseAmount, manualLottoNumbers.map { LottoNumbers(it.map(::LottoNumber)) })
    }
}
