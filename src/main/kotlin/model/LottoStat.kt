package model

data class LottoStat(val rank: Rank, val count: Int) {
    val prizeMoney
        get() = rank.prizeMoney * count
}
