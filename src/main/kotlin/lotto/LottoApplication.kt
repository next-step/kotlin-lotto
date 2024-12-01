package lotto

fun main() {
    val lottoAuto = LottoAuto()
    try {
        lottoAuto.start()
    } catch (e: Exception) {
        println("오류 : $e")
    }
}
