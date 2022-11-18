package calculator.domain

class StringAddCalculator(
    private val input: String
) {

    fun calculate(): Int {
        val stringSplit = StringSplit(input)
        val splitList = stringSplit.splitString()

        return splitList.map { StringConvert.toInt(it) }.sum()
    }
}
