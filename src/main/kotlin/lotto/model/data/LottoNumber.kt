package lotto.model.data

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber) = this.number.compareTo(other.number)
    override fun toString() = this.number.toString()
}

class LottoNumberRange(override val start: LottoNumber, override val endInclusive: LottoNumber) :
    ClosedRange<LottoNumber>, Iterable<LottoNumber> {
    constructor(intRange: IntRange) : this(LottoNumber(intRange.first), LottoNumber(intRange.last))

    override fun iterator() = LottoNumberIterator(start, endInclusive)

    fun toIntRange() = IntRange(start.number, endInclusive.number)
}

class LottoNumberIterator(private val start: LottoNumber, private val endInclusive: LottoNumber) :
    Iterator<LottoNumber> {

    private var offset = start

    override fun hasNext() = (this.offset <= endInclusive)
    override fun next(): LottoNumber {
        var offsetInt = this.offset.number

        val nextValue = LottoNumber(offsetInt++)
        this.offset = LottoNumber(offsetInt)
        return nextValue
    }
}

fun String.toBlankRemovedLottoNumbers() =
    this.split(",").map { it.trim().toInt() }
        .map { LottoNumber(it) }
