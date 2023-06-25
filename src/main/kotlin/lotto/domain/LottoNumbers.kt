package lotto.domain

class LottoNumbers(numbers: List<LottoNumber>) {

    val lottoNumbers: List<LottoNumber> = numbers

    fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.count { it.value in other.lottoNumbers.map { num -> num.value } }
    }
}
