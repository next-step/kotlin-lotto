package lotto

fun main() {
    val expense = UserInput.Int("구입금액을 입력해 주세요.")
        .answer()
        .let { Money(it) }

    val lottoNumbers = LottoAgent(LottoDrawMachine((1..45)))
        .exchange
        .let {
            it.pay(expense)
            it.product()
        }

    Output.PickNumber(lottoNumbers).write()

    val result = LottoGame(winningNumbers(), lottoNumbers).result

    Output.LottoResult(result).write()
}

private fun winningNumbers(): WinningNumbers {
    val winningNumber = UserInput.IntList("지난 주 당첨 번호를 입력해 주세요.").answer()
        .let {
            LottoNumbers(it)
        }
    val bonusNumber = UserInput.Int("보너스 볼을 입력해 주세요.").answer()
    return WinningNumbers(winningNumber, bonusNumber)
}
