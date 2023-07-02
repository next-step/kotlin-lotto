package lotto.domain

class ManualLottoCount(
    val count: Int,
    val price: Int
) {

    var availableAutoCount: Int = 0

    init {
        require(count * Lotto.LOTTO_PRICE <= price) { "수동으로 구매할 로또의 숫자가 초과되었습니다." }

        availableAutoCount = (price / Lotto.LOTTO_PRICE) - count
    }
}
