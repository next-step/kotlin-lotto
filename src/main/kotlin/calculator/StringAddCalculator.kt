package calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {
        if(input.isNullOrEmpty()) {
            return ZERO
        }

        val stringList = split(input)

        return stringAdd(stringList)
    }

    fun split(input: String): List<String> {
        return input.split(",|:".toRegex())
    }

    fun stringAdd(input: List<String>): Int {
        return input.sumOf { it.toInt() }
    }

    companion object {
        private const val ZERO: Int = 0
    }
}
