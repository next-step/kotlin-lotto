package lotto.domain

class WinningLotto(
    val lotto: Lotto,
) {
    fun contains(lottoNumber: LottoNumber): Boolean {
        return lotto.contains(lottoNumber)
    }
}
