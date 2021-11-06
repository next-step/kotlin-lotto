package lotto.domain

class Lotto {

    val lottoNumber: List<Int> = (1..45).shuffled().subList(0, 6).sorted()
}
