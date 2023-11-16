package lotto.domain

class LottoBuyStrategy(totalMoney: Money, val manualLottoList: List<LottoNumbers>) {
    constructor(totalMoney: Money, lottoList: LottoList) : this(totalMoney, lottoList.lottoList.map { it.lottoNumbers })

    private val totalCount = totalMoney.amount / LottoBooth.LOTTO_PRICE
    private val manualCount = manualLottoList.size
    val autoCount = totalCount - manualCount

    init {
        require(manualCount <= totalCount) {
            "Manual lotto count must be lower than total lotto count"
        }
    }
}
