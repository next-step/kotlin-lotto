package lotto.domain

data class WinningLottoNumbers(
    val lottoNumbers: LottoNumbers,
    val bonusLottoNumber: LottoNumber,
) {

    init {
        require(!lottoNumbers.contains(bonusLottoNumber)) {
            "보너스 숫자는 당첨번호 6개와 중복될 수 없습니다."
        }
    }
}
