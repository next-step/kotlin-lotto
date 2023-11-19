package lotto

class WinningLotto(val winningNumber: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!winningNumber.lottoNumbers.contains(bonusNumber)) {
            "보너스볼 번호는 당첨 번호에 포함되지 않은 번호를 입력해주세요."
        }
    }
}
