package lotto

import lotto.domain.LottoAgent
import lotto.domain.LottoDrawMachine
import lotto.domain.LottoGame
import lotto.domain.LottoNumbers
import lotto.domain.Money
import lotto.view.Output
import lotto.view.UserInput

fun main() {
    val expense = UserInput.Int("구입금액을 입력해 주세요.")
        .answer()
        .let { Money(it) }

    val manualPickCount = UserInput.Int("\n수동으로 구매할 로또 수를 입력해 주세요.").answer()

    val manualPickNumbers = UserInput.IntListGroup("\n수동으로 구매할 번호를 입력해 주세요.", manualPickCount)
        .answer()
        .map { LottoNumbers(it) }

    val lottoNumbers = LottoAgent(LottoDrawMachine((1..45)))
        .exchange
        .let {
            it.pay(expense, manualPickNumbers)
            it.product()
        }

    Output.printPickNumber(manualPickCount, lottoNumbers)

    val winningNumbers = UserInput.winningNumbers()

    val result = LottoGame(winningNumbers, lottoNumbers).result

    Output.printLottoResult(result)
}
