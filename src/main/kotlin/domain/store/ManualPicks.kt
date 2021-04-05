package domain.store

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.lotto.Lottos

class ManualPicks(val list: List<LottoNumbers>) {
    val size: Int
        get() = list.size

    fun toLottos(): Lottos = Lottos(list.map { Lotto(it) })
}
