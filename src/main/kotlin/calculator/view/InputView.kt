package calculator.view

object InputView {

    fun readInput(): String? {
        println("계산할 식을 입력하세요.")
        return readLine()
    }
}
