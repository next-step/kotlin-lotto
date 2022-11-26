package lotto.domain

class Winner(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!winningLotto.contains(bonusLottoNumber)) { "지난 주 당첨 번호를 제외한 숫자를 입력해주세요." }
    }

    fun match(lottoList: List<Lotto>): Map<Reward, Int> {
        val matchStore: Map<Pair<Int, Boolean>, Int> = lottoList
            .groupingBy { lotto ->
                val matchCount = this.winningLotto.match(lotto, bonusLottoNumber).size
                val matchBonus = lotto.contains(bonusLottoNumber)

                matchCount to matchBonus
            }
            .eachCount()

        return Reward.values().associateWith { reward ->
            val matchResult = reward.matchCount to reward.hasBonus
            matchStore[matchResult] ?: 0
        }
    }

    fun getIncomeRate(purchaseCount: Int, matchReward: Map<Reward, Int>): Double =
        matchReward.map { (reward, resultCount) -> reward.amount * resultCount }
            .sum()
            .toDouble()
            .div(purchaseCount * Lotto.PRICE)
}
