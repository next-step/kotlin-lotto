package lotto.domain

class ManualLottoSelector(private val numbers: List<Int>) : LottoSelector {
    override fun select(): Lotto {
        val lottoNumbers = numbers.map { LottoNumber.from(it) }
            .toSet()

        return Lotto(lottoNumbers)
    }
}
