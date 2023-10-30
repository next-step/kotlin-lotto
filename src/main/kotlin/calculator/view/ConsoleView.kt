package calculator.view

class ConsoleView {
    fun inputFormula(): String? {
        println("식을 입력하세요 (예:\"1,2\" \"1:2,3\")")
        return readlnOrNull()
    }

    fun outputResult(result: Int) {
        println("실행결과 : $result")
    }
}
