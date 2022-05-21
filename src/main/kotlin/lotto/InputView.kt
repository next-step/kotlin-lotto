package lotto

class InputView {

    fun payment(): String {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull() ?: throw IllegalArgumentException()
    }
}
