package lotto.domain

class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == COUNT) { "로또는 6자리 숫자가 필요합니다." }
    }

    fun match(lotto: Lotto): Set<LottoNumber> =
        this.lottoNumbers.intersect(lotto.lottoNumbers)

    companion object {
        const val COUNT = 6
        const val PRICE = 1_000
    }
}
