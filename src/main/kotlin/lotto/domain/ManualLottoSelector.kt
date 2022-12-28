package lotto.domain

class ManualLottoSelector(private val numbers: Set<Int>) : LottoSelector {
    constructor(numbers: IntArray) : this(numbers.toSet())

    override fun select(): Lotto {
        val lottoNumbers = numbers.map { LottoNumber.from(it) }
            .toSet()

        return Lotto(lottoNumbers)
    }
}
