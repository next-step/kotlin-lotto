package calculator

object StringCalculator {

    fun calculate(inputs: String?): Int {
        return Numbers(Parser.parse(inputs)).sum
    }
}
