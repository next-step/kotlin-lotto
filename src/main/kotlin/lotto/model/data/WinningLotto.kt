package lotto.model.data

data class WinningLotto private constructor(val numbers: Set<Int>, val bonusNumber: Int) {

    companion object {
        fun Lotto.toWinningLotto(policy: Policy, bonusNumber: Int): WinningLotto {
            require(bonusNumber !in this.numbers) { "보너스 번호는 로또 번호와 겹칠 수 없습니다." }
            require(bonusNumber in policy.rangeOfNumbers)
            return WinningLotto(this.numbers, bonusNumber)
        }
    }
}
