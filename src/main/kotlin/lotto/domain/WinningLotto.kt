package lotto.domain

class WinningLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!(lotto.lottoNumbers.contains(bonusNumber)))
    }
}
