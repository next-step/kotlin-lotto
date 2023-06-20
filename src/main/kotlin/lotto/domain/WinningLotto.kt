package lotto.domain

class WinningLotto(
    lotto: Lotto,
    val bonusLottoNumber: LottoNumber,
) {
    val lottoNumbers: List<LottoNumber>

    init {
        lottoNumbers = lotto.lottoNumbers
        require(lottoNumbers.none { it == bonusLottoNumber }) { "당첨 로또 번호와 보너스 번호는 중복될 수 없습니다." }
    }
}
