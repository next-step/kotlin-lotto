package lotto.model

import kotlin.random.Random

class Ticket(length: Int? = null, range: IntRange? = null, numbers: List<Int>? = null) {
    var numbers: List<Int> = emptyList()
        private set

    init {
        if (numbers != null && numbers.size == numbers.toSet().size) {
            this.numbers = numbers
        } else if (length != null && range != null) {
            val result = mutableListOf<Int>()
            while (result.size < length) {
                var randomNumber: Int? = null
                while (true) {
                    randomNumber = Random.nextInt(range.first, range.last)
                    if (!result.contains(randomNumber)) {
                        result.add(randomNumber);
                        break;
                    }
                }
            }
            this.numbers = result.toList()
        } else {
            throw IllegalArgumentException("잘못된 인자를 넣었습니다")
        }
    }


}
