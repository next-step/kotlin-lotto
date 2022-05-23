package lotto

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val price = readln().toInt()
    } catch (e: NumberFormatException) {
        println("숫자가 아닌 값이 들어왔습니다")
    }

}
