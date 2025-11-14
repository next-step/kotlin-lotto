package lotto

class Lotto(input: List<Int>) {
    val numbers = input
    constructor() : this((1..45).toList().shuffled().take(6))
}
