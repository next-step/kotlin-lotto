package calculator.view

object InputView {

    fun inputString(): String {
        print("연산할 문자를 입력해주세요: ")
        val input = readln()
        return input.toZeroIfBlank()
    }

    private fun String.toZeroIfBlank(): String {
        return this.ifBlank { "0" }
    }
}
