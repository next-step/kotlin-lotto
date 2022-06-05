package lotto.domain

class LottoBuyer(lottoNumbers: List<Lotto>) {
    val lottoNumbers = lottoNumbers.toList()

    companion object {
        const val PRICE = 1000
        fun buyer(money: Int): LottoBuyer {
            val lottoNumbers = ArrayList<Lotto>()
            repeat(money / PRICE) {
                lottoNumbers.add(Lotto.random())
            }
            return LottoBuyer(lottoNumbers)
        }
    }
}
