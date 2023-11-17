package lottoAuto.domain

data class WinningLotto(
    val winningLottoNumbers: List<LottoNumber>
) {
    fun countSameNumber(lotto: Lotto): Int {
        return winningLottoNumbers.intersect(
            lotto.lottoNumbers.toSet()
        ).size
    }
}
