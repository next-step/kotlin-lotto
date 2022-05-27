package calculator.splitter

interface Splitter {
    fun isApplicable(input: String): Boolean
    fun trySplit(input: String): List<String>
}
