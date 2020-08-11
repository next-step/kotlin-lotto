package model

data class LottoStat(val rank: Rank, val count: Int) {

    fun grade(): Int {
        return rank.grade
    }

    fun isOverGrade(grade: Int): Boolean {
        return rank.grade > grade
    }

    fun sumPrizeMoney(): Int {
        return rank.sumPrizeMoney(count)
    }
}
