package lotto.domain

class LottoGame(
    private var lottoIssuer: LottoIssuer = LottoIssuer(),
) {
    private var _purchaseMoney: Long? = null
    private var _lottos: List<Lotto>? = null

    val lottos: List<Lotto>
        get() = _lottos ?: throw IllegalStateException("아직 로또를 구매하지 않았습니다.")

    val purchaseMoney: Long
        get() = _purchaseMoney ?: throw IllegalStateException("아직 구입금액을 지불하지 않았습니다.")

    fun purchaseLotto(purchaseMoney: Long) {
        this._purchaseMoney = purchaseMoney
        this._lottos = lottoIssuer.issueLottoByAuto(purchaseMoney)
    }

    fun generateLottoGameResult(winningLottoNumbers: Set<Int>): LottoGameResult {
        return LottoGameResult(
            purchaseMoney = purchaseMoney,
            winningLottoNumbers = winningLottoNumbers,
            lottos = lottos,
        )
    }
}
