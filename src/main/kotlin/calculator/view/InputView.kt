package calculator.view

class InputView {

    fun inputString(): String {
        print("연산할 문자를 입력해주세요: ")
        val input = readLine()!!
        return toNullOrBlank(input)
    }

    fun toNullOrBlank(input: String?): String {
        return if (input.isNullOrBlank()) "0" else input
    }
}
