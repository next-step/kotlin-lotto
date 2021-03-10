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

    val winningNumber = WinningNumber.Console("지난 주 당첨 번호를 입력해 주세요.").lottoNumbers

    val result = LottoGame(lottoNumbers, winningNumber).result

    Output.LottoResult(result).write()
}
