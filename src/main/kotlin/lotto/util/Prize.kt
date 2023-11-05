package lotto.util

import lotto.Lotto
import lotto.Lottos

enum class Prize(val prize: Int, val match: Int) {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NO_PRIZE(0, -1);

    companion object {
        private val prizeMap = Prize.values().associateBy { it.match }

        fun getResult(lottos: Lottos, winningNumbers: Lotto): List<Prize> {
            return lottos.lottoList.map {
                getPrize(it.matches(winningNumbers))
            }
        }
        fun getPrize(matchNum: Int): Prize = prizeMap[matchNum] ?: NO_PRIZE
        fun countResult(list: List<Prize>, matchNum: Int): Int {
            return list.count { it == getPrize(matchNum) }
        }
    }
}
