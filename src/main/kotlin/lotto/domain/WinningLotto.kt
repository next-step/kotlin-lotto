package lotto.domain

class WinningLotto(
    lottoNumbers: List<LottoNumber>,
    val bonusLottoNumber: LottoNumber,
) : Lotto(lottoNumbers) {
    init {
        require(lottoNumbers.none { it == bonusLottoNumber }) { "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다." }
    }

    constructor(lotto: Lotto, bonusLottoNumber: LottoNumber) : this(lotto.lottoNumbers, bonusLottoNumber)
}
