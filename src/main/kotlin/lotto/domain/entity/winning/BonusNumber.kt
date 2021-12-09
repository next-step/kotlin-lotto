package lotto.domain.entity.winning

import lotto.domain.entity.common.LottoNumber

@JvmInline
value class BonusNumber(
    val lottoNumber: LottoNumber
) {

    fun compareToLottoNumber(paramLottoNumber: LottoNumber): Boolean = this.lottoNumber.number == paramLottoNumber.number

}
