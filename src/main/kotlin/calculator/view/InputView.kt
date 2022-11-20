package calculator.view

class InputView {
    companion object {
        private const val INPUT_MESSAGE = "계산식을 입력해주세요."
        private const val ERROR = "[ERROR] "

        fun inputFormula(): String {
            println(INPUT_MESSAGE)
            return readln()
        }

        fun printError(message: String) {
            println(ERROR + message)
        }
    }
}
