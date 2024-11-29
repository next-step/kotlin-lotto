package lotto

fun main() {
    val lotto = Lotto()
    try {
        lotto.start()
    } catch (e: Exception) {
        println("오류 : $e")
    }
}
