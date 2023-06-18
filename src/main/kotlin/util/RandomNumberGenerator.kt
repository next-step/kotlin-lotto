package util

object RandomNumberGenerator : NumberGenerator {
    override fun randomNumbers(): Set<Int> {
        return (1..45).shuffled().take(6).toSet()
    }
}
