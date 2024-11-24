package stringCalculator.view

import stringCalculator.contorller.View

class ConsoleView : View {
    override fun getFormula(): String? {
        println("식 입력 plz")
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) {
            println("아무것도 입력되지 않았습니다.")
            return null
        }
        return input
    }

    override fun showAnswer(answer: Int) {
        println("결과:$answer")
    }

    override fun showErrorMessage(message: String) {
        println(message)
    }
}
