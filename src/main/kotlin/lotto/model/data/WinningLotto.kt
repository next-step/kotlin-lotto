package lotto.model.data

data class WinningLotto private constructor(val numbers: Set<LottoNumber>, val bonusNumber: LottoNumber) {

    companion object {
        fun Lotto.parseToWinningLotto(policy: Policy, bonusNumber: LottoNumber): ParseResult<WinningLotto> =
            when (val error = policy.validateWinningNumbers(this.numbers, bonusNumber)) {
                null -> ParseResult.Value(WinningLotto(this.numbers, bonusNumber))
                else -> ParseResult.Error(error)
            }
    }
}
