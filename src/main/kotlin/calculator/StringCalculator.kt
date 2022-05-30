package calculator

object StringCalculator {

    fun calculate(inputs: String?): Int {
        if (inputs.isNullOrEmpty()) return 0
        return Numbers.fromStrings(Parser.parse(inputs)).sum
    }
}
