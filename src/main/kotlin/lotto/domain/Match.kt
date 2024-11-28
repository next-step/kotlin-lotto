package lotto.domain

class Match {
    companion object {
        fun lottoNumber(
            userLotto: Lotto,
            winningLotto: Lotto,
        ): Int {
            val lottoNumbers: Set<LottoNumber> = userLotto.lottoNumbers
            val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers
            val matchCount = lottoNumbers.intersect(winningLottoNumbers).size

            return 1
        }
    }
}
