package stringcalculator

class Numbers(private val numbers: List<Number>) : List<Number> by numbers {
    fun sum() =
        numbers.fold(0, { accu, curr -> accu + curr.value })

    companion object {
        fun from(numberStrings: List<String>): Numbers {
            return Numbers(numberStrings.map { Number(it) })
        }
    }
}
