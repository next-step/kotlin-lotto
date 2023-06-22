package lotto.domain

/**
 * 로또를 얼마에 팔지 결정하고 구입 금액만큼 로또를 판매하는 역할을 하는 클래스입니다.
 */
class LottoSeller(
    val lottoPrice: Int = 1000,
    private val lottoMachine: LottoMachine = LottoMachine()
) {

    fun sell(
        money: Int,
        manualLottos: List<Lotto> = listOf()
    ): IssuedLottos {
        val totalCount = money / lottoPrice
        val autoLottos = lottoMachine.issue(totalCount - manualLottos.size)
        return IssuedLottos(
            lottos = manualLottos + autoLottos,
            manualCount = manualLottos.size,
            autoCount = autoLottos.size,
        )
    }
}
