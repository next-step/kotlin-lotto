package stringcalculator.model

object StringCalculator {
    fun sumString(numberList: List<String>) = numberList.sumBy { Number(it).toInt() }
}
