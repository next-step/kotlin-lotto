package lotto

class GameContext(val user: User = User(), val lottoMachine: LottoMachine = LottoMachine()) {
    private lateinit var lastWeekNumbers: Lotto

    fun pay(amount: ViewAmount) {
        user.pay(Amount(amount))
    }

    fun buyManualLottos(manualNumbers: ViewManual) {
        val lottos = manualNumbers.map { Lotto(it.map { number -> LottoNumber(number) }.toSet()) }
        user.buyManualLottos(Lottos(lottos))
    }

    fun buyAutoLotto(autoGenerate: (Amount) -> Lottos) {
        user.buyAutoLotto(autoGenerate)
    }

    fun setLastWeekNumbers(lastWeekNumbers: ViewLastWeekNumbers) {
        this.lastWeekNumbers = Lotto(lastWeekNumbers.map { LottoNumber(it) }.toSet())
    }

    fun statistics(bonusNumber: ViewBonusNumber): LottoStatistics {
        return LottoStatistics.from(user, lastWeekNumbers, LottoNumber(bonusNumber))
    }

    fun generator(): (Amount) -> Lottos {
        return lottoMachine.autoGenerate
    }
}
