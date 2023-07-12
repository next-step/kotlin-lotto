package lotto.domain

data class TypeLotto(
    val lotto: Lotto,
    val type: GenerateType,
) {
    val lottoNumbers: List<LottoNumber>
        get() = lotto.numbers

    companion object {
        fun of(numbers: List<Int>, type: GenerateType): TypeLotto {
            return TypeLotto(Lotto.of(numbers), type)
        }
    }
}
