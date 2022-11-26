package lotto

class InputView {

    fun insertMoney(): String {
        println("구입금액을 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank())
        return input
    }
}
