package domain.lotto

import java.util.SortedSet

class LottoNumbers(val numbers: SortedSet<LottoNumber>) {
    fun countIntersection(other: LottoNumbers): Int {
        return numbers.intersect(other.numbers).size
    }

    init {
        require(numbers.size == SIZE)
    }

    constructor(numbers: List<LottoNumber>) : this(numbers.toSortedSet())

    constructor(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int) : this(
        listOf(n1, n2, n3, n4, n5, n6).map { LottoNumber(it) }
    )

    companion object {
        const val SIZE = 6
    }
}
