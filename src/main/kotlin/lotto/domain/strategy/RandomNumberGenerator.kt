package lotto.domain.strategy

object RandomNumberGenerator : NumberGenerator {
    override fun generate(size: Int): List<Int> = (1..size).map { rangedRandomNumber() }

    private fun rangedRandomNumber(): Int = (1..45).random()
}
