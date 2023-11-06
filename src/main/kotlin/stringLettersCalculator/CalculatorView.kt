package stringLettersCalculator

object CalculatorView {

    fun inputLetters(message: String): String {
        try {
            println(message)
            return readln().replace("\\n","\n")
        } catch (e: Exception) {
            throw IllegalArgumentException("문자열수식을 입력해 주세요.")
        }
    }

    fun printResult(result : Int) {
        println("계산 결과 : $result")
    }
}