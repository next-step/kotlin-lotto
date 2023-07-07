package lotto.domain

class ManualLottoCount(
    val count: Int,
    val price: Int
) {

    val availableAutoCount: Int

    init {
        require(count * Lotto.LOTTO_PRICE <= price) { "수동으로 구매할 로또의 숫자가 초과되었습니다." }

        availableAutoCount = (price / Lotto.LOTTO_PRICE) - count
    }
}
