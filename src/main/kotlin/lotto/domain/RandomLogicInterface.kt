package lotto.domain

import lotto.data.LottoNumber

interface RandomLogicInterface {
    fun createRandomLotto(numbers: Map<Int, LottoNumber>): LinkedHashSet<LottoNumber>
}
