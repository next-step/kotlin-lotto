package lotto

fun main() {
    val inputView = InputView()

    val userMoneyInput = inputView.getUserMoney()

    val lottoStore = LottoStore(userMoneyInput)

}