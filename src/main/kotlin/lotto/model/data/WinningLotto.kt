package lotto.model.data

data class WinningLotto private constructor(val numbers: Set<Int>, val bonusNumber: Int) {

    companion object {
        fun Lotto.toWinningLotto(policy: Policy, bonusNumber: Int): WinningLotto {
            require(bonusNumber !in this.numbers)
            require(bonusNumber in policy.rangeOfNumbers)
            return WinningLotto(this.numbers, bonusNumber)
        }
    }
}
