package lottery.domain.ranking

import lottery.domain.winningresult.NumberOfWins

enum class Ranking(val rank: NumberOfWins, val prize: Int) {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000)
}