package lotto

data class Statistics(
    var result: Long = 0,
    var three: Int = 0,
    var four: Int = 0,
    var five: Int = 0,
    var six: Int = 0
) {

    private var none: Int = 0
    fun plusCount(result: Int) {
        when (result) {
            3 -> {
                three++
                this.result = this.result + MatchEnum.THREE.amount
            }
            4 -> {
                four++
                this.result = this.result + result + MatchEnum.FOUR.amount
            }
            5 -> {
                five++
                this.result = this.result + result + MatchEnum.FIVE.amount
            }
            6 -> {
                six++
                this.result = this.result + result + MatchEnum.SIX.amount
            }
            else -> none++
        }
    }

    fun getReport() {
        println("당첨 통계")
        println("---------")
        printResult(MatchEnum.THREE, this.three)
        printResult(MatchEnum.FOUR, this.four)
        printResult(MatchEnum.FIVE, this.five)
        printResult(MatchEnum.SIX, this.six)
    }

    private fun printResult(matchEnum: MatchEnum, matchCount: Int) {
        println("${matchEnum.count}개 일치 (${matchEnum.amount}원) - ${matchCount}개")
    }

    fun getResult(insertAmount: Int) {
        println("총 수익률은 ${getResultRate(insertAmount)} 입니다. ")
    }

    private fun getResultRate(insertAmount: Int): String {
        val result = result.toDouble() / insertAmount.toDouble()
        return String.format("%.2f", result)
    }
}
