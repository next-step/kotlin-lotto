package view.manualpick

import domain.store.ManualPicks
import view.ParsedLottoNumbers

class ManualPickInput(private val lottoNumbers: List<ParsedLottoNumbers>) {
    fun toManualPicks(): ManualPicks {
        return ManualPicks(lottoNumbers.map { it.toLottoNumbers() })
    }
}
