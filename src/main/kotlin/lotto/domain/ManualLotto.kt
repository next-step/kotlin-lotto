package lotto.domain

data class ManualLotto(private val manualLottoNumbers: List<Set<Int>>) {
    fun numberOfManualLottos() = manualLottoNumbers.size

    fun toLotto(): List<Lotto> {
        return manualLottoNumbers.map {
            LottoNumber.of(it)
        }.map { Lotto(it) }.toList()
    }
}
