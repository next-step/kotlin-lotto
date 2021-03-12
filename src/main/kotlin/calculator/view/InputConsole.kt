package calculator.view

object InputConsole {
    fun run(): String? {
        println("계산 식을 입력해 주세요.")
        return readLine()
    }
}
