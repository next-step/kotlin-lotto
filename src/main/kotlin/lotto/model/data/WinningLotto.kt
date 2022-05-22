package lotto.model.data

data class WinningLotto private constructor(val numbers: Set<Int>, val bonusNumber: Int) {

    companion object {
        fun Lotto.toWinningLotto(policy: Policy, bonusNumber: Int): WinningLotto {
            policy.validateWinningNumbers(this.numbers, bonusNumber)
            return WinningLotto(this.numbers, bonusNumber)
        }
    }
}
