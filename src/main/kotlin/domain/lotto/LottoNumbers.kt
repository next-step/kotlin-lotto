package domain.lotto

import java.util.SortedSet

class LottoNumbers(val numbers: SortedSet<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }

    constructor(numbers: List<LottoNumber>) : this(numbers.toSortedSet())

    fun countIntersection(other: LottoNumbers): Int {
        return numbers.intersect(other.numbers).size
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as LottoNumbers
        if (countIntersection(other) == SIZE) return true
        return false
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        const val SIZE = 6
    }
}
