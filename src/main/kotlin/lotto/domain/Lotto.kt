package lotto.domain

class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == COUNT) { "로또는 6자리 숫자가 필요합니다." }
    }

    fun match(lotto: Lotto, bonusLottoNumber: LottoNumber? = null): Set<LottoNumber> =
        this.lottoNumbers
            .let { numbers ->
                if (bonusLottoNumber != null) numbers.plus(bonusLottoNumber) else numbers
            }
            .intersect(lotto.lottoNumbers)

    fun contains(lottoNumber: LottoNumber): Boolean = this.lottoNumbers.contains(lottoNumber)

    companion object {
        const val COUNT = 6
        const val PRICE = 1_000
    }
}
