package lotto.domain

@JvmInline
value class LottoNumbersList(val value: List<LottoNumbers>) {
    fun getList(): List<List<Int>> {
        return value.map { it.value.map { lottoNumber -> lottoNumber.value } }
    }
}
