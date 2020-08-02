package stringcalculator.model

object StringCalculator {
    fun sumString(numberList: List<String>) = numberList.sumBy(String::getPositiveNumber)
}

fun String.getPositiveNumber(): Int {
    val numInteger = (if (this.isEmpty()) "0" else this).toIntOrNull()
    require(numInteger != null) { "숫자가 아닌 값을 입력하셨습니다." }
    require(numInteger >= 0) { "0보다 큰수로 입력하세요." }
    return numInteger
}
