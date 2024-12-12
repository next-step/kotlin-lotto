package lotto.domain

@JvmInline
value class ManualLotto(val manualLottoNumbers: List<Set<Int>>) {
    fun numberOfManualLottos() = manualLottoNumbers.size
}
