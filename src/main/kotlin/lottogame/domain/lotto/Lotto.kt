package lottogame.domain.lotto

data class Lotto(
    val lottoNumbers: LottoNumbers,
    val type: GenerationType,
) {
    val numbers: List<LottoNumber>
        get() = lottoNumbers.value

    companion object {
        fun of(numbers: List<Int>, type: GenerationType): Lotto {
            return Lotto(LottoNumbers.of(numbers), type)
        }
    }
}
