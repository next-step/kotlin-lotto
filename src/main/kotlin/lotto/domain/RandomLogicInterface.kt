package lotto.domain

import lotto.data.LottoNumber

interface RandomLogicInterface {
    fun createAutoLotto(numbers: Map<Int, LottoNumber>): Set<LottoNumber>
}
