package lotto.domain

object LottoNumbersMatcher {
    fun calculateMatchCount(purchaseLotto: Lotto, winningLotto: Lotto): Int {
        return purchaseLotto.lottoNumbers.intersect(winningLotto.lottoNumbers.toSet()).size
    }
}
