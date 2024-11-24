package lotto

class OutputView {
    companion object {
        fun printResult(result: List<Int>) {
            StringBuilder().apply {
                append("당첨 통계\n")
                append("---------\n")
                append("3개 일치 (5000원)- ${result.count { it == 3 }}개\n")
                append("4개 일치 (50000원)- ${result.count { it == 4 }}개\n")
                append("5개 일치 (1500000원)- ${result.count { it == 5 }}개\n")
                append("6개 일치 (2000000000원)- ${result.count { it == 6 }}개\n")
            }.also(::println)
        }
    }
}