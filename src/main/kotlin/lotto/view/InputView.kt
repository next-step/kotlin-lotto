package lotto.view

class InputView {

    companion object {
        private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
        private const val BOUGHT_LOTTO_MESSAGE = "개를 구매했습니다."
        private const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val DELIMITERS = ", "

        fun inputPrice(): Int? {
            println(INPUT_PRICE_MESSAGE)
            return readLine()!!.toIntOrNull()
        }

        fun printBoughtLotto(lottoCount: Int) {
            println("${lottoCount}$BOUGHT_LOTTO_MESSAGE")
        }

        fun inputWinningNumber(): List<String> {
            println(INPUT_WINNING_NUMBER_MESSAGE)
            return readLine()?.split(DELIMITERS) ?: emptyList()
        }
    }
}
