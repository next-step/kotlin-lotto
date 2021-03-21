package lotto.domain

class BuyingLotto(
    price: LottoPrice,
    manualLottoNumbers: ManualNumbers
) {
    val manualLotto: List<Lotto> = manualLottoNumbers.toLottos()
    val automaticCount: Int = price.calculateAutomaticCount(manualLotto.size)
}
