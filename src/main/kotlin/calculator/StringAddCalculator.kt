package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        val params = Params(text)
        return params.intList.fold(0) { acc, i -> acc + i }
    }
}
