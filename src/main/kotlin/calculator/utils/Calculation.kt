package calculator.utils

object Calculation {

    fun stringArraySum(strings: List<String>) =
        strings.sumOf {
            if (!Validation.isNumeric(it)) throw RuntimeException("입력된 값이 숫자가 아닙니다.")
            if (Validation.isNegativeNumber(it)) throw RuntimeException("입력된 값이 음수 입니다.")
            it.toInt()
        }
}
