package lotto.domain

import lotto.domain.dto.LottoNumber

class LottoStore(insertAmount: Int, manualLottoList: List<LottoNumber>) {

    init {
        require(insertAmount / LOTTO_UNIT_PRICE >= manualLottoList.count()) {
            "로또 구매 가능 갯수보다 수동 구매 갯수가 더 많습니다."
        }
    }

    val autoPurchasableCount = insertAmount / LOTTO_UNIT_PRICE - manualLottoList.count()

    val manualPurchasedCount = manualLottoList.count()

    private val manualLottoNumbers = manualLottoList

    private val autoPurchasedLottoNumbers = List(autoPurchasableCount) { LottoNumberGenerator.autoGenerate() }
    fun purchased(): List<LottoNumber> {
        return manualLottoNumbers + autoPurchasedLottoNumbers
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }
}
