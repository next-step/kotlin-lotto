package stringcalculator

object StringCalculator {
    fun sumString(numberList: List<String>) = numberList.sumBy(String::getPositiveNumber)
}

fun String.getPositiveNumber(): Int {
    val num = this.toIntOrNull()
    require(num != null) { "숫자가 아닌 값을 입력하셨습니다." }
    require(num >= 0) { "0보다 큰수로 입력하세요." }
    return num
}
