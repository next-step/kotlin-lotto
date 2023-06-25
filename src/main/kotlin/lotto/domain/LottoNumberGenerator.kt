package lotto.domain

object LottoNumberGenerator {
    fun generate(): List<LottoNumber> {
        return (1..45).shuffled().subList(0, 6).map { it.toLottoNumber() }
    }
}
