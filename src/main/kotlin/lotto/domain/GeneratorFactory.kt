package lotto.domain

interface GeneratorFactory {
    fun createNumberGenerator(): () -> Int
}
