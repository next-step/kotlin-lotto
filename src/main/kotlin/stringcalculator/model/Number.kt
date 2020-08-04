package stringcalculator.model

class Number(numberStr: String) {
    var number = 0
        private set

    init {
        number = if (numberStr.isEmpty()) 0 else converter(numberStr)!!
    }

    private fun converter(numberStr: String) =
        numberStr.toIntOrNull().also {
            require(it != null) { "숫자가 아닌 값을 입력하셨습니다." }
            require(it >= 0) { "0보다 큰수로 입력하세요." }
        }

    fun toInt() = number
}
