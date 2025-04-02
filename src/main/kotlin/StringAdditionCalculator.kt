class StringAdditionCalculator {
    fun sum(text: String): Int {
        val tokens = text.split(",|:".toRegex())
        var sum: Int = 0
        for (token in tokens) {
            sum += token.toInt()
        }
        return sum
    }
}
