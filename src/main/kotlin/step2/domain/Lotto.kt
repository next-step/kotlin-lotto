package step2.domain

data class Lotto(var numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "6자리의 번호가 필요합니다." }
    }
}

fun List<Lotto>.getAnswerCountList(answer: Lotto): List<Int> {
    return this.map { lotto ->
        lotto.numbers.map {
            var result = 0
            if (answer.numbers.contains(it)) {
                result++
            }
            result
        }.count { it > 0 }
    }
}
