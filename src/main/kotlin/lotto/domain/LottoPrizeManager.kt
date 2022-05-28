package lotto.domain

class LottoPrizeManager {
    private val lottoPrizePolices: MutableList<LottoPrizePolicy> = mutableListOf()
    val polices
        get() = lottoPrizePolices.toList()

    fun addUniquePolicy(prizePolicy: LottoPrizePolicy) {
        validateUniqueItem(prizePolicy)
        lottoPrizePolices.add(prizePolicy)
    }

    private fun validateUniqueItem(prizePolicy: LottoPrizePolicy) {
        lottoPrizePolices.forEach {
            require(it.wonMatchedCount != prizePolicy.wonMatchedCount) { "동일한 당첨 정책이 존재합니다" }
        }
    }
}
