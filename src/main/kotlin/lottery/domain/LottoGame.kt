package lottery.domain

class LottoGame(
    val lottoMoney: LottoMoney,
    private val lottos: Lottos,
) {
    constructor(lottoMoney: LottoMoney, manualLottoMachine: LottoMachine, autoLottoMachine: LottoMachine) : this(
        lottoMoney = lottoMoney,
        lottos = Lottos(manualLottoMachine.createLottos(lottoMoney.manualLottoCount) + autoLottoMachine.createLottos(lottoMoney.autoLottoCount)),
    )

    val userLottos: List<Lotto>
        get() = lottos.lottos

    fun getRanks(winningLotto: WinningLotto): Ranks {
        return Ranks(lottos, winningLotto, lottoMoney.money)
    }

    companion object {
        const val LOTTERY_PRICE = 1000
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }
}
