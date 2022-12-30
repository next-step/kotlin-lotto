package lotto.domain

import lotto.domain.Lotto.Companion.PRICE
import lotto.model.LottoNumbers

class LottoTicket(
    val purchaseAmount: Int,
    _manualLottoNumbers: List<LottoNumbers> = emptyList(),
) {
    val manualLottoNumbers: List<LottoNumbers> = sortedLottoNumbers(_manualLottoNumbers)

    init {
        require(purchaseAmount >= PRICE) { "로또를 구매하려면 최소 ${PRICE}원 이상의 금액이 필요합니다." }
        require((purchaseAmount / PRICE) >= manualLottoNumbers.size) { "수동으로 구매할 로또 수가 구매 금액을 초과할 수 없습니다." }
    }

    private fun sortedLottoNumbers(lottoNumbers: List<LottoNumbers>): List<LottoNumbers> =
        lottoNumbers.map { LottoNumbers(it.value.sortedBy { number -> number.value }) }

    val autoLottoNumbersSize: Int
        get() = (purchaseAmount / PRICE) - manualLottoNumbers.size

    val manualLottoNumbersSize: Int
        get() = manualLottoNumbers.size
}
