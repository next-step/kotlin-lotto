package lotto.view

private const val COUNT_STRING = "개를 구매했습니다."

object ResultView {
    fun printLottoCounts(count: Int) {
        println("${count}$COUNT_STRING")
    }
}