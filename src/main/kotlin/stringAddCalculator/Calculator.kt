package stringAddCalculator

object Calculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return input.toInt()
    }

    fun splitString(input: String): List<String> {
        return input.split(",|:".toRegex())
    }

    fun convertInt(inputList: List<String>): List<Int> {
        return inputList.map { it.toInt() }
    }

    fun add(numberList: List<Int>): Int {
        return numberList.sum()
    }
}
