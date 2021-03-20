package lotto.domain

class ManualLottoCount(
    buyingPrice: LottoPrice,
    val count: LottoCount
) {
    init {
        require(count <= buyingPrice.getMaximumCount()) {
            "구입금액을 초과하는 수동티켓은 구입할 수 없습니다."
        }
    }
}