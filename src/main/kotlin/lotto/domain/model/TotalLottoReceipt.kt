package lotto.domain.model

data class TotalLottoReceipt(
    val manual: LottoReceipt,
    val automatic: LottoReceipt
) {
    val lottos = manual.lottos + automatic.lottos
}
