package lotto.domain

class LottoBuyer(lottoBuyList: List<LottoNumbers>) {
    val lottoBuyList = lottoBuyList.toList()

    companion object {
        fun buyer(manualLottoNumbers: List<LottoNumbers>, autoLottoCount: Int): LottoBuyer {
            val lottoBuyList = ArrayList<LottoNumbers>()
            lottoBuyList.addAll(manualLottoNumbers)
            repeat(autoLottoCount) {
                lottoBuyList.add(LottoNumbers.random())
            }
            return LottoBuyer(lottoBuyList)
        }
    }
}
