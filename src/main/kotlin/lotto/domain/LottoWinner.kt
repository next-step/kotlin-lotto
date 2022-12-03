package lotto.domain

class LottoWinner(
    val luckNumberList: List<Int>,
    val lottoList: List<Lotto>
) {

    fun findWinLottoList(): List<Reward> {
        return lottoList
            .map { it.countHitNumbers(luckNumberList) }
            .filter { hasPrize(it) }
            .map { Reward.from(it) }
    }

    private fun hasPrize(count: Int) = count >= Reward.MINIMUM_HIT_COUNT
}
