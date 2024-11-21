package calculator

class CalculatorView {
    fun getInput(): String {
        println("계산할 문자열을 입력하세요.")
        return readln()
    }

    fun displayResult(result: Int) {
        println(result)
    }
}
