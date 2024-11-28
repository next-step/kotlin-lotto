package lotto

class GameContext(val user: User = User(), val lottoMachine: LottoMachine = LottoMachine()) {
    private lateinit var lastWeekNumbers: Lotto

    fun pay(amount: Amount) {
        user.pay(amount)
    }

    fun buyManualLottos(manual: Lottos) {
        user.buyManualLottos(manual)
    }

    fun buyAutoLotto(autoGenerate: (Amount) -> Lottos) {
        user.buyAutoLotto(autoGenerate)
    }

    fun setLastWeekNumbers(lastWeekNumbers: Lotto) {
        this.lastWeekNumbers = lastWeekNumbers
    }

    fun statistics(bonusNumber: LottoNumber): LottoStatistics {
        return LottoStatistics.from(user, lastWeekNumbers, bonusNumber)
    }

    fun generator(): (Amount) -> Lottos {
        return lottoMachine.autoGenerate
    }
}
