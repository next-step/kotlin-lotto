package lotto

class Statistics {
    var result: Long = 0
    var three: Int = 0
    var four: Int = 0
    var five: Int = 0
    var six = 0
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
}
