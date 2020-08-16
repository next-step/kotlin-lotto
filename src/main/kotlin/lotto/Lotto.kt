package lotto

class Lotto(lottoNumbers: List<LottoNumber>) {
    private val lottoNumbers: List<LottoNumber> = lottoNumbers

    fun matchCount(winningLotto: Lotto): Int {
        return winningLotto.lottoNumbers.filter {
            lottoNumbers.contains(it)
        }.size
    }

    fun matchBonus(bonus: LottoNumber): Boolean {
        return lottoNumbers.contains(bonus)
    }
}
