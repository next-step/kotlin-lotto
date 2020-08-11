package model

data class LottoStat(val rank: Rank, val count: Int) {

    fun getGrade(): Int {
        return rank.grade
    }

    fun getSumPrizeMoney(): Int {
        return rank.sumPrizeMoney(count)
    }
}
