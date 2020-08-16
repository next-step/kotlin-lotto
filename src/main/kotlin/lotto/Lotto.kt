package lotto

class Lotto(lottoNumbers: List<LottoNumber>) {
    private val lottoNumbers: List<LottoNumber> = lottoNumbers

    fun match(winningLotto: Lotto): Int {
        return winningLotto.lottoNumbers.filter {
            lottoNumbers.contains(it)
        }.size
    }
}
