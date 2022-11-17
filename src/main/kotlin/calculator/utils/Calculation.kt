package calculator.utils

object Calculation {

    fun stringArraySum(strings: List<String>) =
        strings.sumOf {
            if (!Validation.isNumeric(it)) throw RuntimeException()
            if (Validation.isNegativeNumber(it)) throw RuntimeException()
            it.toInt()
        }
}
