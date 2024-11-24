package calculator

object InputView {
    fun inputExpression(): String {
        println("계산할 문자열을 입력하세요.")
        return readln()
    }
}
