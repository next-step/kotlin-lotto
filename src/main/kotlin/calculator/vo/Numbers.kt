package calculator.vo

data class Numbers(private val intNumbers: List<IntNumber>) {
    fun sum(): IntNumber = intNumbers.reduce { acc, intNumber -> acc.plus(intNumber) }
}
