package lotto.agency.number


object LottoNumberCache {
    private val CACHE_LOTTO_NUMBER: MutableList<LottoNumber> = ArrayList()

    init {
        for (i in 1..45) {
            CACHE_LOTTO_NUMBER.add(LottoNumber(i))
        }
    }

    fun valueOf(number: Int): LottoNumber {
        return CACHE_LOTTO_NUMBER[number - 1]
    }
}
