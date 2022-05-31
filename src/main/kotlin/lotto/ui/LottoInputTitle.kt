package lotto.ui

object LottoInputTitle {

    private const val INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_WINNING_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun requestPurchaseLotto() = println(INPUT_PURCHASE_PRICE)
    fun requestWinningLotto() = println(INPUT_WINNING_LOTTO)
    fun requestWinningLottoBonusNumber() = println(INPUT_WINNING_BONUS_NUMBER)
}
