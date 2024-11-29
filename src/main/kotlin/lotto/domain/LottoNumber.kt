package lotto.domain

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in lottoNumberRange)
    }

    companion object {
        private val lottoNumberRange = 1..45

        private val lottoNumbers: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun get(lottoNumber: Int): LottoNumber =
            lottoNumbers[lottoNumber] ?: LottoNumber(lottoNumber).apply {
                lottoNumbers[lottoNumber] = this
            }
    }
}
