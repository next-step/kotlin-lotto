package domain.store

import domain.lotto.Lotto
import domain.lotto.LottoNumbers

class ManualPicks(val list: List<LottoNumbers>) {
    val size: Int
        get() = list.size

    fun toLottoList(): List<Lotto> = list.map { Lotto(it) }
}
