package lotto.model

data class Lotto(
    val lottoNumbers: LottoNumbers
) {

    fun matches(otherNumbers: LottoNumbers): Int {
        return lottoNumbers.matches(otherNumbers)
    }
}
