package lotto.domain

class BuyingLotto(
    val price: LottoPrice,
    manualLottoNumbers: ManualNumbers?
) {
    val manualLotto: List<Lotto> = manualLottoNumbers?.toManualLottoNumber() ?: listOf()
    private val manualLottoCount: LottoCount = LottoCount.from(manualLotto.size)
    val automaticCount: LottoCount = price.calculateAutomaticCount(manualLottoCount)
}
