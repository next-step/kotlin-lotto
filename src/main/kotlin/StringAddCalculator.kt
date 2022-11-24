import java.lang.RuntimeException

class StringAddCalculator(strExpression: String?) {
    var result: Int = 0
    var arrNumber: List<String> = ArrayList()

    init {
        if (strExpression.isNullOrEmpty())
            result = 0
        else {
            checkCustomDelimiter(strExpression)
        }
    }

    fun checkCustomDelimiter(strExpression: String) {
        val check = Regex("//(.)\n(.*)").find(strExpression)
        if (check != null) {
            check.let {
                val customDelimiter = it.groupValues[1]
                arrNumber = it.groupValues[2].split(customDelimiter)
                amountArrNumber()
            }
        } else {
            splitCommaAndColon(strExpression)
        }
    }

    fun splitCommaAndColon(strExpression: String) {
        arrNumber = strExpression.split(",|:".toRegex())
        strExpressionSizeCheck(arrNumber)
    }

    fun strExpressionSizeCheck(arrNumber: List<String>) {
        if (arrNumber.size == 1) {
            result = checkNagative(arrNumber.get(0).toInt())
        } else {
            amountArrNumber()
        }
    }

    fun amountArrNumber() {
        for (i: Int in arrNumber.indices) {
            result += checkNagative(arrNumber.get(i).toInt())
        }
    }

    fun checkNagative(number: Int): Int {
        if (number < 0) {
            throw RuntimeException("전달 값 음수")
        } else {
            return number
        }
    }
}
