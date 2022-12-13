package lotto.domain

class Ranks(ranks: List<Rank> = listOf()) {
    val missCount: Int = ranks.count { it == Rank.MISS }
    val fifthCount: Int = ranks.count { it == Rank.FIFTH }
    val fourthCount: Int = ranks.count { it == Rank.FOURTH }
    val thirdCount: Int = ranks.count { it == Rank.THIRD }
    val secondCount: Int = ranks.count { it == Rank.SECOND }
    val firstCount: Int = ranks.count { it == Rank.FIRST }

    val size = ranks.size

    val totalPrize: Int =
        Rank.FIRST.calculatePrize(firstCount) + Rank.SECOND.calculatePrize(secondCount) +
            Rank.THIRD.calculatePrize(thirdCount) + Rank.FOURTH.calculatePrize(fourthCount) +
            Rank.FIFTH.calculatePrize(fifthCount)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Ranks) return false

        if (missCount != other.missCount) return false
        if (fifthCount != other.fifthCount) return false
        if (fourthCount != other.fourthCount) return false
        if (thirdCount != other.thirdCount) return false
        if (secondCount != other.secondCount) return false
        if (firstCount != other.firstCount) return false
        if (size != other.size) return false
        if (totalPrize != other.totalPrize) return false

        return true
    }

    override fun hashCode(): Int {
        var result = missCount
        result = 31 * result + fifthCount
        result = 31 * result + fourthCount
        result = 31 * result + thirdCount
        result = 31 * result + secondCount
        result = 31 * result + firstCount
        result = 31 * result + size
        result = 31 * result + totalPrize.hashCode()
        return result
    }
}
