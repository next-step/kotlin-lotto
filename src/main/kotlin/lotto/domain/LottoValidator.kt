package lotto.domain

object LottoValidator {
    private const val LOTTO_PRICE = 1000

    fun manualLottoValidate(money: Int, lottoCount: Int) {
        require(money> lottoCount * LOTTO_PRICE) { "${money}원으로는 수동 ${lottoCount}장을 구매할 수 없습니다." }
    }
}
