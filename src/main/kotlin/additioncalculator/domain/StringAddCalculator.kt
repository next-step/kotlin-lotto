package additioncalculator.domain
class StringAddCalculator {
    fun add(text: String?): Int {
        return NumberSplit(text).splitNumberResult().sum()
    }
}