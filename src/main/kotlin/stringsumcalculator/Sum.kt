package stringsumcalculator

class Sum(private val numbers: Numbers) : Number {
    override fun toInt(): Int {
        return numbers.toList()
            .sumOf { it.toInt() }
    }
}
