package lottoAuto.domain

data class Lotto (
    val lottoNumbers: LottoNumbers
) {
    fun match(lotto: Lotto): Boolean {
        return lottoNumbers.countSameNumber(lotto.lottoNumbers) == LottoNumbers.NUM_OF_LOTTO_NUMBERS
    }
}
