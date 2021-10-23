package calculator.view

class ConsoleResultView : ResultView {
    override fun showResult(result: Int) {
        println("결과: $result")
    }
}
