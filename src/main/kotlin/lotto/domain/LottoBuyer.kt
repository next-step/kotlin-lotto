package lotto.domain

class LottoBuyer(lottoNumbers: ArrayList<Lotto>) {
    private val _lottoNumbers = lottoNumbers
    val lottoNumbers
        get() = _lottoNumbers

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
