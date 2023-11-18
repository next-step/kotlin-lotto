package lotto.domain

import lotto.domain.number.LottoNumber

class WinningLotto private constructor(
    val lotto: Lotto,
    val bonusNumber: LottoNumber,
) {

    fun getLottoNumbers(): Set<LottoNumber> =
        lotto.numbers.toSet()

    companion object {
        fun createResult(lotto: Lotto, bonusNumber: LottoNumber): WinningLottoResult {
            if (lotto.hasBonusBall(bonusNumber)) {
                return WinningLottoResult.Failure("보너스 볼은 당첨 번호와 중복될 수 없습니다.")
            }
            return WinningLottoResult.Success(WinningLotto(lotto, bonusNumber))
        }
    }
}
