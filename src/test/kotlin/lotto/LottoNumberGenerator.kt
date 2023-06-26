package lotto

object LottoNumberGenerator {
    fun create() = (1..45).shuffled().subList(0, 6).sorted().map { LottoNumber(it) }
}
