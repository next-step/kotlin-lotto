package lotto.domain

class Lotto(
    val lottoNumbers: List<LottoNumber>,
) {

    init {
        require(lottoNumbers.size == 6) { "로또 번호는 6개여야 합니다." }
    }

    fun match(winningLotto: Lotto): LottoRank {
        val matchNumberCount = lottoNumbers.count { it in winningLotto.lottoNumbers }
        return LottoRank.from(matchNumberCount)
    }
}
