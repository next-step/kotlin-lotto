package lotto.model.data

data class WinningLotto private constructor(val numbers: Set<LottoNumber>, val bonusNumber: LottoNumber) {

    companion object {
        fun Lotto.toWinningLotto(policy: Policy, bonusNumber: LottoNumber): WinningLotto {
            policy.validateWinningNumbers(this.numbers, bonusNumber)
            return WinningLotto(this.numbers, bonusNumber)
        }
    }
}
