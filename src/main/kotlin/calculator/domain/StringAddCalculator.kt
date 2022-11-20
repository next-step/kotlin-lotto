package calculator.domain

class StringAddCalculator(
    private val input: String
) {

    fun String.toPositiveInt(): Int {
        val result = this.toInt()
        require(result >= 0) { "음수는 입력할 수 없습니다." }
        return result
    }

    fun calculate(): Int {
        val stringSplit = StringSplit(input)
        val splitList = stringSplit.splitString()

        return splitList.map { it.toPositiveInt() }.sum()
    }
}
