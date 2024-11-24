package lotto.domain

class Lotto private constructor(
    val pickNumbers: List<Int>,
    matchCount: Int,
) {
    init {
        require(pickNumbers.distinct().size == 6) { "로또 번호는 6개여야 합니다. [pickNumbers=${this.pickNumbers}]" }
    }

    var matchCount: Int = matchCount
        private set

    fun updateMatchCount(value: Int): Lotto {
        this.matchCount = value
        return this
    }

    override fun toString(): String {
        return "Lotto(pickNumbers=$pickNumbers, matchCount=$matchCount)"
    }

    companion object {
        fun of(pickNumbers: List<Int>): Lotto {
            return Lotto(pickNumbers = pickNumbers, matchCount = 0)
        }
    }
}
