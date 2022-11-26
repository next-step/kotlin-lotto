package lotto.ui

class InputView {

    companion object {

        fun requireAmountOfPurchaseLotto(): Int {
            println("구입금액을 입력해주세요.")
            return consoleInput()
        }

        fun requireWinLottoNum(): Int {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return consoleInput()
        }

        private fun consoleInput(): Int = readln().toInt()
    }
}