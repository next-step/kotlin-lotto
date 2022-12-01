package stringsumcalculator

class Sum(private val numbers: Numbers) : INumber {
    override fun toInt(): Int {
        return numbers.toList()
            .sumOf { it.toInt() }
    }
}
