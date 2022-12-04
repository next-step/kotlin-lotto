package lotto

class BonusNumber(private val lottoNumbers: WinningLottoNumbers, val lottoNumber: LottoNumber) {
    init {
        if (lottoNumbers.contains(lottoNumber)) {
            throw IllegalArgumentException("당첨 번호와 중복되는 번호를 생성할 수 없습니다.")
        }
    }
}