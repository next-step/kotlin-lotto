package util

val randomNumberGenerator: NumberGenerator = NumberGenerator {
    (1..45).shuffled().take(6).toSet()
}
