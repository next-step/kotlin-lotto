package stringcalculator

class Numbers(private val numbers: List<String>) : List<String> by numbers {
    fun sum() =
        numbers.fold(0, { accu, curr -> accu + curr.toInt() })
}
