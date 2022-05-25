package calculator

object StringCalculator {

    fun calculate(inputs: String?): Int {
        if (inputs.isNullOrEmpty()) return 0
        return Numbers(Parser.parse(inputs)).sum
    }
}
