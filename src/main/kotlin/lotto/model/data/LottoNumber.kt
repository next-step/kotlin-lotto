package lotto.model.data

@JvmInline
value class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber) = this.number.compareTo(other.number)
    override fun toString() = this.number.toString()
}

data class LottoNumbers(val lottoNumberList: List<LottoNumber>) : List<LottoNumber> by lottoNumberList {
    companion object {
        fun List<Int>.toLottoNumbers() = LottoNumbers(this.map { LottoNumber(it) })
    }
}

class LottoNumberRange(override val start: LottoNumber, override val endInclusive: LottoNumber) :
    ClosedRange<LottoNumber>, Iterable<LottoNumber> {
    constructor(intRange: IntRange) : this(LottoNumber(intRange.first), LottoNumber(intRange.last))

    override fun iterator() = LottoNumberIterator(start, endInclusive)

    fun toIntRange() = IntRange(start.number, endInclusive.number)
}

class LottoNumberIterator(private var offset: LottoNumber, private val endInclusive: LottoNumber) :
    Iterator<LottoNumber> {

    override fun hasNext() = (this.offset <= endInclusive)
    override fun next(): LottoNumber {
        val offsetInt = this.offset.number
        val nextValue = LottoNumber(offsetInt)
        this.offset = LottoNumber(offsetInt + 1)
        return nextValue
    }
}
