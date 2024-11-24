package lotto

class FixedNumberGenerator : NumberGenerator {
    override fun generate(): Set<Int> {
        return setOf(1, 2, 3, 4, 5, 6)
    }
}
