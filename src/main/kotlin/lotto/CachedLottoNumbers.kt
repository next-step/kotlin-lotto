package lotto

object CachedLottoNumbers {
    private val lottoNumberMap: MutableMap<Int, LottoNumber> = HashMap()

    init {
        for (i in 1..45) {
            lottoNumberMap[i] = LottoNumber(i)
        }
    }

    fun getLottoNumber(value: Int): LottoNumber {
        return lottoNumberMap.getOrPut(value) { LottoNumber(value) }
    }
}
