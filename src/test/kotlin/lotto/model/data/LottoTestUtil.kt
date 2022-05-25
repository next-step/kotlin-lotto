package lotto.model.data

import lotto.model.data.Lotto.Companion.parseToLotto
import lotto.model.data.WinningLotto.Companion.parseToWinningLotto
import org.assertj.core.util.VisibleForTesting

@VisibleForTesting
fun String.toLottoNumber(): LottoNumber {
    return LottoNumber(this.trim().toInt())
}

@VisibleForTesting
fun String.toLottoNumbers() =
    CommaSeparatedInt(this).toLottoNumbers()

@VisibleForTesting
fun String.toLotto(policy: Policy) = CommaSeparatedInt(this).toLotto(policy)

@VisibleForTesting
fun LottoNumbers.toLotto(policy: Policy): Lotto {
    policy.validateNumbers(this)
    return this.parseToLotto(policy).forceSucceed()
}

@VisibleForTesting
fun CommaSeparatedInt.toLotto(policy: Policy): Lotto {
    return this.toLottoNumbers()
        .toLotto(policy)
}

@VisibleForTesting
fun Lotto.toWinningLotto(policy: Policy, bonusNumber: LottoNumber): WinningLotto {
    return this.parseToWinningLotto(policy, bonusNumber)
        .forceSucceed()
}

@VisibleForTesting
fun <T> ParseResult<T>.forceSucceed() = (this as ParseResult.Value<T>).value
