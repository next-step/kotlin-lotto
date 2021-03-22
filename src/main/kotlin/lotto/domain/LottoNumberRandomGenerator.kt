package lotto.domain

class LottoNumberRandomGenerator(private val min: Int, private val max: Int) : LottoNumberGenerator {
    constructor() : this(LottoNumber.LOTTO_MINIMUM_NUMBER, LottoNumber.LOTTO_MAXIMUM_NUMBER)

    override fun pickNumber(): Set<LottoNumber> = (min..max).shuffled()
        .slice(0 until LottoTicket.LOTTO_NUMBER_COUNT)
        .map { LottoNumber.from(it) }
        .toSet()
}
