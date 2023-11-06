package lotto.domain

enum class Prize(val prize: Int, val match: Int) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NO_PRIZE(0, -1);

    companion object {
        private val prizeMap = Prize.values().associateBy { it.match }

        fun getResult(lottos: Lottos, winningNumbers: Lotto, bonus: Int): List<Prize> {
            return lottos.lottoList.map {
                getPrize(it, winningNumbers, bonus)
            }
        }
        fun getPrize(lotto: Lotto, winningNumbers: Lotto, bonus: Int): Prize {
            val matchNum = lotto.matches(winningNumbers)

            return if (matchNum == 5) {
                if (lotto.numbers.contains(bonus)) SECOND else THIRD
            } else {
                prizeMap[matchNum] ?: NO_PRIZE
            }
        }
    }
}
