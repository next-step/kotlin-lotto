package lotto.entity

import lotto.domain.LottoNumber

class Lotto(val manualLotto: MutableList<LottoNumber>, val autoLotto: MutableList<LottoNumber>) {
    fun getTotalLottoInfos(): List<LottoNumber> {
        return manualLotto + autoLotto
    }
}
