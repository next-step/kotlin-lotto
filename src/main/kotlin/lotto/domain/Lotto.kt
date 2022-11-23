package lotto.domain

class Lotto {

    val list: List<Int> = (1..45)
        .shuffled()
        .subList(0, 6)
}
