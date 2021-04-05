package view.manualpick

import domain.store.ManualPicks
import view.ParsedManualNumbers

class ManualPickInput(private val lottoNumbers: List<ParsedManualNumbers>) {
    fun toManualPicks(): ManualPicks {
        return ManualPicks(lottoNumbers.map { it.toLottoNumbers() })
    }
}
