package lotto

class InputView {
    fun getMoney(): Int {
        println(INPUT_MONEY)
        return readln().toIntOrNull() ?: throw RuntimeException()
    }

    companion object {
        private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    }
}
