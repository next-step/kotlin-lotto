package calculator.view

class InputView {

    fun inputString(): String {
        print("연산할 문자를 입력해주세요: ")
        val input = readln()
        return toifBlankZero(input)
    }

    fun toifBlankZero(input: String): String {
        return input.ifBlank { "0" }
    }
}
