package lottery.domain

data class LotteryCount(val count: Int) {
    override fun toString(): String {
        return "$count"
    }
}
