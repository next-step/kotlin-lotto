package lotto.domain

class Lotto(val lottoNumbers: List<LottoNumber>) {
    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }
}
