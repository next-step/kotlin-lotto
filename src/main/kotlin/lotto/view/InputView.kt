package lotto.view

class InputView {

    companion object {
        private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
        private const val BOUGHT_LOTTO_MESSAGE = "개를 구매했습니다."

        fun inputPrice(): Int? {
            println(INPUT_PRICE_MESSAGE)
            return readLine()!!.toIntOrNull()
        }

        fun printBoughtLotto(lottoCount: Int) {
            println("${lottoCount}$BOUGHT_LOTTO_MESSAGE")
        }
    }
}
