package lotto.domain

class Lotto(val lottoNumbers: LottoNumbers) {
    fun getNumbers(): List<LottoNumber> {
        return lottoNumbers.getNumbers()
    }
}