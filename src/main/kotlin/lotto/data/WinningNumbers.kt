package lotto.data

class WinningNumbers(
    lottoNumbers: List<Int>,
    bonusNumber: Int
) {
    val lottoNumbers: LottoNumbers = LottoNumbers(lottoNumbers)
    val bonusNumber: LottoNumber = LottoNumber.from(bonusNumber)

    init {
        require(!lottoNumbers.contains(bonusNumber)) { "보너스 숫자가 로또 숫자와 중복되었습니다." }
    }
}
