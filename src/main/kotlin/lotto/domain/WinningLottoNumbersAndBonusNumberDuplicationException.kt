package lotto.domain

class WinningLottoNumbersAndBonusNumberDuplicationException(lotto: LottoNumbers, bonusNumber: LottoNumber) : RuntimeException(
    "WinningLotto의 로또 번호와 보너스 번호는 중복될 수 없습니다. 로또 번호=$lotto, 보너스 번호=$bonusNumber"
)
