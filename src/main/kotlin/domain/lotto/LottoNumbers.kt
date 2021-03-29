package domain.lotto

import java.util.SortedSet

class LottoNumbers(private val numbers: SortedSet<LottoNumber>) {
    init {
        require(numbers.size == SIZE)
    }

    fun toList(): List<LottoNumber> {
        return numbers.toList()
    }

    fun countIntersection(other: LottoNumbers): Int {
        return numbers.intersect(other.numbers).size
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as LottoNumbers
        if (numbers != other.numbers) return false
        return true
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        const val SIZE = 6

        fun fromList(numbers: List<LottoNumber>): LottoNumbers = LottoNumbers(numbers.toSortedSet())
    }
}
