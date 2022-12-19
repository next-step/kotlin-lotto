package lotto.domain.vo

@JvmInline
value class LotteryNumber(
    val value: Int
) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { "로또 추첨 숫자는 ${MIN_NUMBER}부터 ${MAX_NUMBER}사이 입니다." }
    }

    override fun toString(): String {
        return this.value.toString()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        val LOTTERY_NUMBER_LIST = (MIN_NUMBER..MAX_NUMBER).map(::LotteryNumber).toList()
    }
}
