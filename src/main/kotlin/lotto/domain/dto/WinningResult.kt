package lotto.domain.dto

data class WinningResult(val winNum: Int, val prize: Int, val count: Int) {
    fun printResult() {
        println("${winNum}개 일치 ${prize}원- ${count}개")
    }
}
