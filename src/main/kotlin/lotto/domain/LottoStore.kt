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

    fun purchase(): List<LottoNumber> {
        val lottoList = mutableListOf<LottoNumber>()
        lottoList.addAll(manualLottoNumbers)
        repeat(this.autoPurchasableCount) { lottoList.add(LottoNumberGenerator.autoGenerate()) }
        return lottoList.toList()
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }
}
