package lotto

data class Lotto(
    private val lottoNumbers: LottoNumbers
) {

    fun matches(otherNumbers: LottoNumbers): Int {
        return lottoNumbers.matches(otherNumbers)
    }
}
