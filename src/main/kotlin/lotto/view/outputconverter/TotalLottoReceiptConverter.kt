package lotto.view.outputconverter

import lotto.domain.model.TotalLottoReceipt

object TotalLottoReceiptConverter : OutputConverter<TotalLottoReceipt> {
    override fun convert(printable: TotalLottoReceipt): String {
        return "${printable.lottoCountText()}\n${LottosConverter.convert(printable.lottos)}"
    }

    private fun TotalLottoReceipt.lottoCountText(): String {
        return "수동으로 ${manual.purchaseCount.value}장, 자동으로 ${automatic.purchaseCount.value}장을 구매했습니다."
    }
}
