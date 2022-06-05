package lotto.domain

class LottoBuyer(lottoBuyList: List<LottoNumbers>) {
    val lottoBuyList = lottoBuyList.toList()

    companion object {
        const val PRICE = 1000
        fun buyer(money: Int): LottoBuyer {
            val lottoBuyList = ArrayList<LottoNumbers>()
            repeat(money / PRICE) {
                lottoBuyList.add(LottoNumbers.random())
            }
            return LottoBuyer(lottoBuyList)
        }
    }
}
