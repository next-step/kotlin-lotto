package lotto.domain

import lotto.domain.model.*

object BonusLottoNumberCreateMachine {
    fun createBonusLottoNumber(bonusLottoNumber: Int, winningLottoNumbers: LottoNumbers): LottoNumber {
        require(winningLottoNumbers.value.all { winningLottoNumber -> winningLottoNumber.value != bonusLottoNumber }) {
            "보너스 넘버와 당첨 로또 번호는 겹칠 수 없습니다."
        }
        return LottoNumber.valueOf(bonusLottoNumber)
    }
}
