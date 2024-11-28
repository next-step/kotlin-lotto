package lotto.util

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Set<Int> {
        return generateSequence { (IntRange(1, 45)).random() }.distinct().take(6).toSet()
    }
}
