package lotto.domain

class Lottos(manualLottoNumbers: List<LottoNumbers>, autoLottoNumbers: List<LottoNumbers>) {
    val lottos: List<LottoNumbers>

    init {
        val mutableList = mutableListOf<LottoNumbers>()
        mutableList.addAll(manualLottoNumbers)
        mutableList.addAll(autoLottoNumbers)
        lottos = mutableList
    }
}
