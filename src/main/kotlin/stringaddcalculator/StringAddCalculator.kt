package stringaddcalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()){
            return 0
        }
        return text.toInt()
    }
}
