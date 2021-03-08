package lotto

fun main() {
    val expense = UserInput.Int("구입금액을 입력해 주세요.")
        .answer()
        .let { Money(it) }

    val lottoNumbers = LottoAgent(LottoDrawMachine((0..45)))
        .exchange
        .let {
            it.pay(expense)
            it.product()
        }

    // PickNumberPrinter(lottoNumbers).print()

    val winningNumber = WinningNumber.Console("지난 주 당첨 번호를 입력해 주세요.").lottoNumber

    val result = LottoGame(lottoNumbers, winningNumber).result

    // ResultPrinter(result).print()
}
