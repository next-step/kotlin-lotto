package util

object RandomNumberGenerator : NumberGenerator {
    override fun randomNumberGenerator(): List<Int> {
        return (1..45).shuffled().take(6)
    }
}
