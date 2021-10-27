package lotto.view

class InputView {

    companion object {
        private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."

        fun inputPrice(): Int {
            println(INPUT_PRICE_MESSAGE)
            return readLine()!!.toInt()
        }
    }
}
