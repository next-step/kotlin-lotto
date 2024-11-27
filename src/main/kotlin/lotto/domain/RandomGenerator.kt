package lotto.domain

object RandomGenerator : LottoNumberGenerator {
    override fun generateLottoNumber(): Int = (1..45).random()
}
